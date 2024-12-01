package cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.http.fallback;

import cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.http.STIXClient;
import feign.RetryableException;
import org.springframework.stereotype.Component;

@Component
public class StixFallback implements STIXClient {
    @Override
    public String getDetails() {
        try{
            throw new RuntimeException ("hi, something wrong");
        } catch (Exception ex) {
            if (ex instanceof RetryableException) {
                return "Bad Request!!!";
            }
            if (ex instanceof RuntimeException) {
                return "Not Found!!!";
            }
            if (ex instanceof Exception) {
                return "Exception!!!";
            }
            return "Successfully Uploaded file!!!";
        }
    }
}
