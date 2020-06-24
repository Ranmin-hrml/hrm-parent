package cn.itsource.hrm.client;


import cn.itsource.hrm.CourseDoc;
import cn.itsource.hrm.client.impl.ESFeignClientImpl;
import cn.itsource.hrm.util.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//用来调用 ES服务的Feign接口
@FeignClient(value = "search-server",path = "/course",fallbackFactory = ESFeignClientImpl.class)
public interface ESFeignClient {
    /**
     * 添加课程到es中
     * @param list
     * @return
     */
    @PostMapping("/addBatch")
    AjaxResult add(@RequestBody List<CourseDoc> list);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("/deleteBatch")
    AjaxResult delete(@RequestBody List<Long> ids);
}
