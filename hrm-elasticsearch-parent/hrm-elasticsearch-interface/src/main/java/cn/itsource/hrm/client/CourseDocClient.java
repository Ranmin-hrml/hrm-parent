package cn.itsource.hrm.client;

import cn.itsource.hrm.client.impl.CourseDocClientImpl;
import cn.itsource.hrm.doc.CourseDoc;
import cn.itsource.hrm.query.CourseDocQuery;
import cn.itsource.hrm.util.AjaxResult;
import cn.itsource.hrm.util.PageList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@Component
@FeignClient(name="elasticsearch-service",path = "/course",fallback = CourseDocClientImpl.class)
public interface CourseDocClient {


    /**
     * 添加课程到es中
     *
     * @param list
     * @return
     */
    @PostMapping("/addBatch")
    AjaxResult add(@RequestBody List <CourseDoc> list);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @PostMapping("/deleteBatch")
    AjaxResult delete(@RequestBody List <Long> ids);

    /**
     * 检索
     *
     * @param query
     * @return
     */
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    PageList <CourseDoc> page(@RequestBody CourseDocQuery query);
}
