package cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.http;

import cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.http.fallback.LiveloFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "livelo", url = "http://localhost:3000/", configuration = ClientsConfiguration.class, fallbackFactory = LiveloFallbackFactory.class)
public interface LiveloClient {
    @GetMapping(value = "/livelo")
    String getDetails();

}
