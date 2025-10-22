package cryss.dev.estrutura_de_dados_java.chainofresponsability;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManipuladorDescontoUserHabilitadoTest {

    @Test
    void testaCadeiaManipuladorQueAplicaDesconto(){
// Essa estratégia, como tem retorno, pode parar no primeiro manipulador
// só não pararia se eu não retornasse nada, deixando o fluxo seguir ate o final
        CadeiaDeManipuladores descontoAtivos =
                new ManipuladorDescontoUserHabilitado ();

        CadeiaDeManipuladores descontoJaComDesconto =
                new ManipuladorDescontoJaPossuiDesconto();

        OrderUser orderUser = OrderUser
                .builder ()
                .isActive (Boolean.TRUE)
                .build ();

        descontoAtivos.setNext (descontoJaComDesconto);
        var resultado = descontoAtivos.manipula (orderUser);

        System.out.println (resultado.getCumulativeDiscount ());

    }

}