package cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.http;

import cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.http.fallback.StixFallbackFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "stix", url = "http://localhost:3000/", configuration = ClientsConfiguration.class, fallbackFactory =  StixFallbackFactory.class)

public interface STIXClient {
    @Cacheable(cacheNames = "demo-cache")
    @GetMapping(value = "/stix")
    String getDetails();

}
