package cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.http.fallback;

import cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.http.StixClient;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class StixFallbackFactory implements FallbackFactory<StixClient> {
    @Override
    public StixClient create(Throwable cause) {
        return new StixClient () {
            @Override
            public String getDetails() {
                return "Somethig goes wrong" + cause.getMessage ();
            }
        };
    }
}
