package cn.itsource.hrm.config;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class DocumentationConfig implements SwaggerResourcesProvider {
    @Override
    public List<SwaggerResource> get() {
        List resources = new ArrayList<>();
        resources.add(swaggerResource("系统管理", "/services/system/v2/api-docs", "2.0"));
        resources.add(swaggerResource("课程中心", "/services/course/v2/api-docs", "2.0"));
        resources.add(swaggerResource("文件服務", "/services/file/v2/api-docs", "2.0"));
        resources.add(swaggerResource("缓存服務", "/services/cache/v2/api-docs", "2.0"));
        resources.add(swaggerResource("全文检索服務", "/services/elasticsearch/v2/api-docs", "2.0"));
        resources.add(swaggerResource("用户服務", "/services/user/v2/api-docs", "2.0"));
        resources.add(swaggerResource("短信服務", "/services/sms/v2/api-docs", "2.0"));
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}