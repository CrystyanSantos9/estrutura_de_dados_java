package cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.interceptors;

import feign.RequestInterceptor;
import org.apache.http.entity.ContentType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Preciso do configuration e do application properties configurado
@Configuration
public class LoyaltyClientInterceptor {
    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("user", "Crystyan");
            requestTemplate.header("password", "password");
            requestTemplate.header("Accept", ContentType.APPLICATION_JSON.getMimeType ());
        };
    }
}
