package F1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("drivers", r -> r
                        .host("localhost:8080")
                        .and()
                        .path("/api/drivers/**", "/api/teams/*/drivers/**")
                        .uri("http://localhost:8082")
                )
                .route("teams", r -> r
                        .host("localhost:8080")
                        .and()
                        .path("/api/teams/**")
                        .uri("http://localhost:8081")
                )
                .build();
    }
}