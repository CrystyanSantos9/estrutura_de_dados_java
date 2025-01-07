package cryss.dev.estrutura_de_dados_java.validadores;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith (SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
class ValidadorGeralTest {
    @Autowired
    private ValidadorGeral service;

    @Test
    void validaGeral_TemOsDoisCarts() {

        CartType cartType1 = CartType.GUEST;
        CartType cartType2 = CartType.CUSTOMER;

        service.validaGeral (cartType1, cartType2);
        System.out.println ("Foi pra fora...");
    }

    @Test
    void validaGeral_ApenasOCustomer() {

        CartType cartType1 = null;
        CartType cartType2 = CartType.CUSTOMER;

        service.validaGeral (cartType1, cartType2);
        System.out.println ("Foi pra fora...");
    }

    @Test
    void validaGeral_ApenasOGuest() {

        CartType cartType1 = CartType.GUEST;
        CartType cartType2 = null;

        service.validaGeral (cartType1, cartType2);
        System.out.println ("Foi pra fora...");
    }

    @Test
    void validaGeral_NaoTemNenhumCartType() {

        CartType cartType1 = null;
        CartType cartType2 = null;

        service.validaGeral (cartType1, cartType2);
        System.out.println ("Foi pra fora...");
    }


}