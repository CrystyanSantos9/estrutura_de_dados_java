package cryss.dev.estrutura_de_dados_java.validadores;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TestConfig {

    @Bean
    ValidadorGeral getValidadorGeral(){
        return new ValidadorGeral (getValidadores());
    }

    @Bean
    List<ValidadoresDeCartType> getValidadores(){
        ValidadoresDeCartType valid1 = new OsCartsNaoSaoNulos ();
        ValidadoresDeCartType valid2 = new TemApenasCustomer ();
        ValidadoresDeCartType valid3 = new TemApenasGuest ();
        ValidadoresDeCartType valid4 = new TemOsDoisCarts ();

        return List.of (valid1, valid2, valid3, valid4);
    }

}
