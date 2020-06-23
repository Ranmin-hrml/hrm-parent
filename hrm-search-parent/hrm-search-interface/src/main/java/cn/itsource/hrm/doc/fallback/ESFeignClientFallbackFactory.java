package cn.itsource.hrm.doc.fallback;

import cn.itsource.hrm.doc.CourseDoc;
import cn.itsource.hrm.doc.feignclient.ESFeignClient;
import cn.itsource.hrm.query.CourseQuery;
import cn.itsource.hrm.util.AjaxResult;
import cn.itsource.hrm.util.PageList;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ESFeignClientFallbackFactory implements FallbackFactory<ESFeignClient> {
    @Override
    public ESFeignClient create(Throwable throwable) {
        return new ESFeignClient(){
            @Override
            public AjaxResult save(CourseDoc courseDoc) {
                throwable.printStackTrace();
                return AjaxResult.me().setSuccess(false).setMessage("服务不可用");
            }

            @Override
            public AjaxResult deleteById(Long id) {
                throwable.printStackTrace();
                return AjaxResult.me().setSuccess(false).setMessage("服务不可用");
            }

            @Override
            public PageList<CourseDoc> searchCourse(CourseQuery courseQuery) {
                throwable.printStackTrace();
                return new PageList<>();
            }
        };
    }
}
