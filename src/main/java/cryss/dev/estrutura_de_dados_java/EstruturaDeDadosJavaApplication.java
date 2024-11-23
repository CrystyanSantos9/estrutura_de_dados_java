package cryss.dev.estrutura_de_dados_java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EstruturaDeDadosJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstruturaDeDadosJavaApplication.class, args);
	}

}
