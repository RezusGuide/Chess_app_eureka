package java_app.rank_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RankServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RankServiceApplication.class, args);
    }
}
