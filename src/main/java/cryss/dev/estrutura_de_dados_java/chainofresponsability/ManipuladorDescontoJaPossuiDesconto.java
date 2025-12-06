package cryss.dev.estrutura_de_dados_java.chainofresponsability;

import java.math.BigDecimal;
import java.util.Objects;

public class ManipuladorDescontoJaPossuiDesconto extends CadeiaDeManipuladores {

    @Override
    public OrderUser manipula(OrderUser user) {

        System.out.println ("ManipuladorDescontoJaPossuiDesconto");
        //podia ter um try catch também
        if (BigDecimal.ZERO.compareTo (user.getCumulativeDiscount ()) < 0) {

/*            The BigDecimal is immutable so you need to do this:
            BigDecimal result = test.add(new BigDecimal(30));
            System.out.println(result);*/

            user.setCumulativeDiscount (user.getCumulativeDiscount ().add (new BigDecimal ("1.55")));

            //garantindo que todos os manipuladores serão chamados
            //só serão processador se passarem nas condições únicas de cada um
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


//só mandar o pim-integration
//era só mandar um payload de kit, que é o mínimo
//que já passava no v3 - no /products
//apenas alterarando