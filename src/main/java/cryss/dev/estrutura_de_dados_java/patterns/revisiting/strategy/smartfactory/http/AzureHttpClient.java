package cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.smartfactory.http;


import cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.smartfactory.http.configuration.ClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "leveClient", url = "http://localhost:3000/", configuration = ClientConfiguration.class )
public interface AzureHttpClient {
    @RequestMapping(method = RequestMethod.GET, value = "/azure")
    List<String> getBrandsTypeLeve();

}
