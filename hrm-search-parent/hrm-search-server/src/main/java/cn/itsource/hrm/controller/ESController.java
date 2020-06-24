package cn.itsource.hrm.controller;

import cn.itsource.hrm.CourseDoc;
import cn.itsource.hrm.repository.CourseESRepository;
import cn.itsource.hrm.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class ESController {

    @Autowired
    private CourseESRepository courseESRepository;
    

    /**
     * 添加课程到es中
     * @param list
     * @return
     */
    @PostMapping("/addBatch")
    public AjaxResult add(@RequestBody List<CourseDoc> list){
        try {
            courseESRepository.saveAll(list);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("失败!"+e.getMessage());
        }
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("/deleteBatch")
    public AjaxResult delete(@RequestBody List<Long> ids){
        try {
            for (Long id : ids) {
                courseESRepository.deleteById(id);
            }
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("失败!"+e.getMessage());
        }
    }
}
