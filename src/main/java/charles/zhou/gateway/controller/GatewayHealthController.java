package charles.zhou.gateway.controller;

import org.springframework.cloud.gateway.route.RouteDefinition;
//import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import reactor.core.publisher.Mono;

@RestController
@Tag(name = "网关管理", description = "网关健康检查与路由管理") // 必须添加标签
@RequestMapping("/gateway")
public class GatewayHealthController {
	
    @Operation(
            summary = "网关健康检查",
            description = "返回网关运行状态",
            responses = @ApiResponse(responseCode = "200", description = "服务正常")
        )
    @GetMapping("/health")
    public Mono<String> health() {
        return Mono.just("OK,Gateway is Healthy");
    }



    @Operation(summary = "动态路由示例", description = "添加新路由规则")
    @PostMapping("/routes")
    public Mono<String> addRoute(@RequestBody RouteDefinition route) {
        return Mono.just("Route added: " + route.getId());
    }
}