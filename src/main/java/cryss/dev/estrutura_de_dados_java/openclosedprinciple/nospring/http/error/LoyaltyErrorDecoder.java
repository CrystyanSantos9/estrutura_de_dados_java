package cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.http.error;

import feign.Response;
import feign.codec.ErrorDecoder;


//Para lidar com o Response
public class LoyaltyErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()){
            case 400:
                return new Exception();
            case 404:
                return new Exception();
            default:
                return new Exception("Generic error");
        }
    }
}
