package cn.itsource.hrm.client.impl;

import cn.itsource.hrm.CourseDoc;
import cn.itsource.hrm.client.ESFeignClient;
import cn.itsource.hrm.util.AjaxResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ESFeignClientImpl implements ESFeignClient {


    @Override
    public AjaxResult add(List<CourseDoc> list) {
        return AjaxResult.me().setSuccess(false).setMessage("失败");
    }

    @Override
    public AjaxResult delete(List<Long> ids) {
        return AjaxResult.me().setSuccess(false).setMessage("失败!");
    }
}
