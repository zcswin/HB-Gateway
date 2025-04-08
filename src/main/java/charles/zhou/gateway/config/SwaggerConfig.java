package charles.zhou.gateway.config;

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
	
//    @Bean
//    GroupedOpenApi gatewayApi() {
//        return GroupedOpenApi.builder()
//                .group("gateway")
//                .pathsToMatch("/gateway/**")
//                .packagesToScan("charles.zhou.gateway.controller")
//                .addOpenApiMethodFilter(method -> true)
//                .build();
//    }
    
    // 服务提供者分组（匹配网关转发的路径）
//    @Bean
//    GroupedOpenApi serviceProviderApi() {
//        return GroupedOpenApi.builder()
//                .group("service-provider")  // 必须与swagger-ui.urls.name一致
//                .pathsToMatch("/api/service-provider/**") // 匹配网关转发的路径
//                .build();
//    }  

//    @Bean
//    GroupedOpenApi serviceConsumerApi() {
//        return GroupedOpenApi.builder()
//                .group("service-consumer")
//                .pathsToMatch("/api/service-sonsumer/**")
//                .build();
//    }
}