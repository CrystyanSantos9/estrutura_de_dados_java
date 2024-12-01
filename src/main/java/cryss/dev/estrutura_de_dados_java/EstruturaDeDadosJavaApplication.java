package cryss.dev.estrutura_de_dados_java;

import cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.domain.LoyaltyType;
import cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.services.LoyaltyNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableFeignClients
@RequiredArgsConstructor
@EnableScheduling
public class EstruturaDeDadosJavaApplication implements CommandLineRunner {

	private final LoyaltyNotificationService service;


	public static void main(String[] args) {
		SpringApplication.run(EstruturaDeDadosJavaApplication.class, args);
	}


	@Override
//	@Scheduled(fixedDelay = 1L) WRONG
	public void run(String... args) throws Exception {
//		service.sendNotification (LoyaltyType.STIX);
//		service.sendNotification (LoyaltyType.LIVELO);
	}

	@Scheduled(fixedDelay = 3L)
	public void makeCall(){
		service.sendNotification (LoyaltyType.STIX);
		service.sendNotification (LoyaltyType.LIVELO);
	}
}
