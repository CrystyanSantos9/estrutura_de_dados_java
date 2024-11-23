package cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.smartfactory.http.configuration;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

public class ClientConfiguration {
    @Bean
    public OkHttpClient client(){
        return new OkHttpClient.Builder ()
                .connectTimeout (5000, TimeUnit.MILLISECONDS)
                .readTimeout (5000, TimeUnit.MILLISECONDS)
                .build ();
    }
}

