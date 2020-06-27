package cn.itsource.hrm.service.impl;

import cn.itsource.hrm.client.CacheClient;
import cn.itsource.hrm.controller.vo.CrumbVo;
import cn.itsource.hrm.domain.CourseType;
import cn.itsource.hrm.mapper.CourseTypeMapper;
import cn.itsource.hrm.service.ICourseTypeService;
import cn.itsource.hrm.util.AjaxResult;
import cn.itsource.hrm.util.StrUtils;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程目录 服务实现类
 * </p>
 *
 * @author ranmin
 * @since 2020-06-17
 */
@Service
public class CourseTypeServiceImpl extends ServiceImpl<CourseTypeMapper, CourseType> implements ICourseTypeService {

    @Autowired
    private CacheClient cacheClient;

    private final String KEY = "coursetype:tree";

    /**
     * 加载课程类型树的数据
     *
     * @return
     */
    @Override
    public List<CourseType> loadTypeTree() {

        List<CourseType> courseTypeList = new ArrayList<> ();

        //自旋获取锁资源
        while(true){
            //查询redis
            AjaxResult ajaxResult = cacheClient.get(KEY);
            String courseTypeJSON = (String) ajaxResult.getResultObj();
            if(StringUtils.isNotEmpty(courseTypeJSON)){
                //如果有，则直接返回
                courseTypeList = JSONObject.parseArray(courseTypeJSON,CourseType.class);
                return courseTypeList;
            }

            try {
                //上锁
                ajaxResult = cacheClient.setnx("courseTypeKey","1");
                Integer result = (Integer) ajaxResult.getResultObj();
                //上锁成功
                //System.out.println (result);
                if(result==1){
                    //如果没有，则查询数据库
                    courseTypeList = typeTreeByLoopMap();
                    //缓存到redis中
                    courseTypeJSON = JSONObject.toJSONString(courseTypeList);
                    cacheClient.setex(KEY,10*60,courseTypeJSON);
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                cacheClient.deleteKey("courseTypeKey");
            }
        }

        //返回数据
        return courseTypeList;
    }


    @Override
    public List <CrumbVo> loadCrumbs(Long courseTypeId) {

        List<CrumbVo> crumbVos = new ArrayList<>();

        CourseType courseTypes = baseMapper.selectById ( courseTypeId );
        //获取path值
        CourseType courseType = baseMapper.selectById(courseTypeId);
        String path = courseType.getPath();
        path = path.substring(1);
        List<Long> ids = StrUtils.splitStr2LongArr(path, "\\.");

        CrumbVo crumbVo = null;
        //循环一次，就是一级
        for (Long id : ids) {
            crumbVo = new CrumbVo();
            //获取当前级别的类型
            CourseType currentType = baseMapper.selectById(id);
            crumbVo.setCurrentType(currentType);
            //获取当前级别的其他类型
            Long pid = currentType.getPid();
            List<CourseType> otherTypes = baseMapper.selectList(new QueryWrapper<CourseType> ().eq("pid", pid).ne("id", id));
            crumbVo.setOtherTypes(otherTypes);
            crumbVos.add(crumbVo);
        }


        return crumbVos;
    }

    /**
     *
     * 循环+Map的形式
     *
     * @return
     */
    private List<CourseType> typeTreeByLoopMap(){

        //查询所有的课程类型
        List<CourseType> courseTypeList = baseMapper.selectList(null);
        //创建一个集合存放所有的一级类型
        List<CourseType> firstLevleTypes = new ArrayList<>();
        //创建一个Map存放所有类型，Map的key为类型d的i，Map的value为当前类型对象
        Map<Long,CourseType> courseTypeMap = new HashMap<> ();

        //往Map中放值
        for (CourseType courseType : courseTypeList) {
            courseTypeMap.put(courseType.getId(),courseType);
        }

        for (CourseType courseType : courseTypeList) {
            if(courseType.getPid()==0){
                firstLevleTypes.add(courseType);
            }else{
                //如果pid不为0，则嵌套循环查询他的父类型，添加到父类型的children集合中
                CourseType parent = courseTypeMap.get(courseType.getPid());
                if(parent!=null){
                    parent.getChildren().add(courseType);
                }
            }
        }
        return firstLevleTypes;

    }

    @Override
    @Transactional
    public boolean save(CourseType entity) {
        boolean result = super.save(entity);
        synchronizedOperation();
        return result;
    }

    @Override
    @Transactional
    public boolean removeById(Serializable id) {
        boolean result = super.removeById(id);
        synchronizedOperation();
        return result;
    }

    @Override
    @Transactional
    public boolean updateById(CourseType entity) {
        boolean b = super.updateById(entity);
        synchronizedOperation();
        return b;
    }


    /**
     * 增删改时的同步操作
     */
    private void synchronizedOperation(){
        List<CourseType> courseTypes = typeTreeByLoopMap();
        String str = JSONObject.toJSONString(courseTypes);
        cacheClient.setex(KEY,10*60,str);
    }
}
