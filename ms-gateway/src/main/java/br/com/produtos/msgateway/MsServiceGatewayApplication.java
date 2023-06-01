package br.com.produtos.msgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class MsServiceGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsServiceGatewayApplication.class, args);
    }

}
