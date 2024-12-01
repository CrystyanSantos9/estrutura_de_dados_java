package cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.http.fallback;

import cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.http.LiveloClient;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class LiveloFallbackFactory implements FallbackFactory<LiveloClient> {
    @Override
    public LiveloClient create(Throwable cause) {
        return new LiveloClient () {
            @Override
            public String getDetails() {
return "Somethig goes wrong" + cause.getMessage ();
            }
        };
    }
}
