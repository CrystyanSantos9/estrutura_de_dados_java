package cryss.dev.estrutura_de_dados_java.validadores;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Log4j2
public class OsCartsNaoSaoNulos implements ValidadoresDeCartType{
    @Override
    public void accept(CartType cartType1, CartType cartType2) {
        if (Objects.isNull (cartType1) && Objects.isNull (cartType2)){
           log.info ("Passou apenas em {}", new String ("TemApenasCustomer"));
            return;
        }
    }
}
