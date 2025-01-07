package cryss.dev.estrutura_de_dados_java.validadores;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
@Log4j2
public class ValidadorGeral {

    private final List<ValidadoresDeCartType> validadores;

    void validaGeral(CartType cart1, CartType cart2){
        log.info ("Executando ValidadorGeral para os carts {}, {}", cart1, cart2);
        validadores.forEach(validador-> validador.accept(cart1, cart2));
    }



}
