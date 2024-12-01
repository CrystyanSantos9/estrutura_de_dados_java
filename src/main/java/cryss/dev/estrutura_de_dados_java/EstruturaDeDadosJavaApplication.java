package cryss.dev.estrutura_de_dados_java;

import cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.domain.LoyaltyType;
import cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.services.LoyaltyNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@RequiredArgsConstructor
public class EstruturaDeDadosJavaApplication implements CommandLineRunner {

	private final LoyaltyNotificationService service;


	public static void main(String[] args) {
		SpringApplication.run(EstruturaDeDadosJavaApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		service.sendNotification (LoyaltyType.STIX);
	}
}
