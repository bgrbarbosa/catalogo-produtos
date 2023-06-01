package br.com.produtos.recebe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SistemaRecebeProdutosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaRecebeProdutosApplication.class, args);
	}

}
