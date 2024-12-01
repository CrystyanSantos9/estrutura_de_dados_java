package cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "livelo", url = "http://localhost:3000/", configuration = ClientsConfiguration.class)
public interface LiveloClient {
    @GetMapping(value = "/livelo")
    String getDetails();

}
