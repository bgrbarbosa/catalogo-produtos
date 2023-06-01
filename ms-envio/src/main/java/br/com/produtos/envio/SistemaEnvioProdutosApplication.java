package br.com.produtos.envio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SistemaEnvioProdutosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaEnvioProdutosApplication.class, args);
	}

}
