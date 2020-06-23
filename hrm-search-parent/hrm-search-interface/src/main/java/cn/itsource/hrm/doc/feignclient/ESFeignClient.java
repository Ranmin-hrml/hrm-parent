package cn.itsource.hrm.doc.feignclient;


import cn.itsource.hrm.doc.CourseDoc;
import cn.itsource.hrm.doc.fallback.ESFeignClientFallbackFactory;
import cn.itsource.hrm.query.CourseQuery;
import cn.itsource.hrm.util.AjaxResult;
import cn.itsource.hrm.util.PageList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//用来调用 ES服务的Feign接口
@FeignClient(value = "es-server",fallbackFactory = ESFeignClientFallbackFactory.class)
public interface ESFeignClient {
    //保存课程:参数如何接受 : courseDoc 文档对象
    @RequestMapping("/es/save")
    AjaxResult save(@RequestBody CourseDoc courseDoc);

    @RequestMapping("/es/delete/{id}")
    public AjaxResult deleteById(@PathVariable("id") Long id);

    @RequestMapping(value = "/es/searchCourse",method = RequestMethod.POST)
    PageList<CourseDoc> searchCourse(@RequestBody CourseQuery courseQuery);

}
