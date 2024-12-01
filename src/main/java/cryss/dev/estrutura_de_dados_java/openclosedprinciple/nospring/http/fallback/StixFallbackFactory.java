package cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.http.fallback;

import cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.http.STIXClient;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class StixFallbackFactory implements FallbackFactory<STIXClient> {
    @Override
    public STIXClient create(Throwable cause) {
        return new STIXClient () {
            @Override
            public String getDetails() {
return "Somethig goes wrong" + cause.getMessage ();
            }
        };
    }
}
