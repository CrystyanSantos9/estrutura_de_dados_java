package cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.http;

import cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.http.error.LoyaltyErrorDecoder;
import feign.Logger;
import feign.codec.ErrorDecoder;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class ClientsConfiguration {


    @Bean
    public OkHttpClient client() {
        return new OkHttpClient
                .Builder ()
                .connectTimeout (2, TimeUnit.MILLISECONDS)
                .readTimeout (2, TimeUnit.MILLISECONDS)
                .callTimeout(1, TimeUnit.SECONDS)
                .build ();
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new LoyaltyErrorDecoder ();
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
