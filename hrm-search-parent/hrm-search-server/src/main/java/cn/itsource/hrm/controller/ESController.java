package cn.itsource.hrm.controller;

//全文检索

import cn.itsource.hrm.doc.CourseDoc;
import cn.itsource.hrm.query.CourseQuery;
import cn.itsource.hrm.repository.CourseESRepository;
import cn.itsource.hrm.util.AjaxResult;
import cn.itsource.hrm.util.PageList;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ESController {

    @Autowired
    private CourseESRepository courseESRepository;

    //保存课程
    @RequestMapping("/es/save")
    public AjaxResult save(@RequestBody CourseDoc courseDoc){
        //调用Repository保存
        courseESRepository.save(courseDoc);
        return AjaxResult.me();
    }
    //删除
    @RequestMapping("/es/delete/{id}")
    public AjaxResult deleteById(@PathVariable("id") Long id){
        courseESRepository.deleteById(id);
        return AjaxResult.me();
    }

    //课程搜索
    @RequestMapping(value = "/es/searchCourse",method = RequestMethod.POST)
    public PageList<CourseDoc> searchCourse(@RequestBody  CourseQuery courseQuery){
        //把courseQuery封装成 ES的查询对象
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        //组合查询
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        List<QueryBuilder> must = boolQueryBuilder.must();
        List<QueryBuilder> filter = boolQueryBuilder.filter();

        //关键字
        if(StringUtils.hasLength(courseQuery.getKeyword())){
            must.add(QueryBuilders.matchQuery("name",courseQuery.getKeyword()));
        }

        //课程类型

        if(null != courseQuery.getProductType()){
            filter.add(QueryBuilders.termQuery("courseTypeId",courseQuery.getProductType()));
        }

        //最大价格 ：过滤
        if(null != courseQuery.getPriceMax()){
            filter.add(QueryBuilders.rangeQuery("price").lte(courseQuery.getPriceMax()));
        }

        //最小价格
        if(null != courseQuery.getPriceMin()){
            filter.add(QueryBuilders.rangeQuery("price").gte(courseQuery.getPriceMin()));
        }

        queryBuilder.withQuery(boolQueryBuilder);

        //分页
        queryBuilder.withPageable(PageRequest.of(courseQuery.getPageNum ()-1,courseQuery.getPageSize ()));
        //排序
        //查询的字段 ：销量：XL ; 新品:xp    评论:pl   价格:jg   人气:rq
        String sortFieldSn = courseQuery.getSortField();
        if(StringUtils.hasLength(sortFieldSn)){
            //排序字段
            String sortField = null;
            //排序方式：默认倒排
            SortOrder sortType = SortOrder.DESC;
            //根据查询编号确定排序字段
            switch (sortFieldSn.toLowerCase()){
                case "xl": sortField = "buyNumber";break;
                case "xp": sortField = "onlineTime";break;
                case "pl": sortField = "commentNumber";break;
                case "jg": sortField = "price";break;
                case "rq": sortField = "browseNumber";break;
            }
            if (StringUtils.hasLength(courseQuery.getSortType())
                    && "asc".equals(courseQuery.getSortType().toLowerCase())){
                sortType = SortOrder.ASC;
            }
            queryBuilder.withSort(new FieldSortBuilder(sortField).order(sortType));
        }
        SearchQuery searchQuery = queryBuilder.build();
        //执行查询
        Page<CourseDoc> page = courseESRepository.search(searchQuery);

        //返回结果
        return new PageList<CourseDoc>(page.getTotalElements() , page.getContent());
    }
}
