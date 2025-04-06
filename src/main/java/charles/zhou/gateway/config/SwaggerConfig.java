package charles.zhou.gateway.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;

@Configuration
public class SwaggerConfig {    

	@Bean
    OpenAPI gatewayOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Gateway Documentation")
                        .version("1.0")
                        .description("网关文档 + 下游服务聚合"))
                .addTagsItem(new Tag()
                        .name("网关管理")
                        .description("网关健康检查与路由管理"));
    }

    @Bean
    GroupedOpenApi gatewayApi() {
        return GroupedOpenApi.builder()
                .group("gateway")
                .pathsToMatch("/gateway/**")
                .packagesToScan("charles.zhou.gateway.controller")
//                .consumesToMatch("application/json")
//                .producesToMatch("application/json")
                .addOpenApiMethodFilter(method -> true)
                .build();
    }
}