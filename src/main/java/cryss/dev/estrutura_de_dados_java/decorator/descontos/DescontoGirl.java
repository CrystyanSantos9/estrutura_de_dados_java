package cryss.dev.estrutura_de_dados_java.decorator.descontos;

import java.math.BigDecimal;
import java.util.Objects;

public class DescontoGirl extends DescontosMaisBase implements DescontosMais {
    public DescontoGirl(Order order) {
        super (order);
    }

    public DescontoGirl(DescontosMais desconto, Order order) {
        super (desconto, order);
    }

    @Override
    public void calculaDesconto() {
        if(DescontosEnum.COMUM.equals (this.order.getDesconto ())){
            BigDecimal descontoComum = new BigDecimal ("0.55");
            order.setDescontoAcumulado (descontoComum.add (order.getDescontoAcumulado ()));
        }
        if(Objects.nonNull (this.desconto)){
            this.desconto.calculaDesconto ();
        }
    }
}
