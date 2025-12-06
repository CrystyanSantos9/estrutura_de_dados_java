package cryss.dev.estrutura_de_dados_java.chainofresponsability;

import java.math.BigDecimal;
import java.util.Objects;

public class ManipuladorDescontoUserHabilitado extends CadeiaDeManipuladores {

    @Override
    public OrderUser manipula(OrderUser user) {
        System.out.println ("ManipuladorDescontoUserHabilitado");
        //podia ter um try catch também
        if (user.getIsActive ()) {

            /*            The BigDecimal is immutable so you need to do this:
            BigDecimal result = test.add(new BigDecimal(30));
            System.out.println(result);*/

            user.setCumulativeDiscount (user.getCumulativeDiscount ().add (new BigDecimal ("2.55")));
            return Objects.nonNull (super.proximoManipulador) ?
                    this.proximoManipulador.manipula (user) :
                    user;
        }
        //passa pro próximo se não pode processar
        return Objects.nonNull (super.proximoManipulador) ?
                this.proximoManipulador.manipula (user) :
                user;
    }
}

//preparar com um produto já existente no v3
//preparar para levantar para v3
//já deixar no ponto