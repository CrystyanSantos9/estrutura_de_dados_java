package cryss.dev.estrutura_de_dados_java.decorator.descontos;

import java.math.BigDecimal;
import java.util.Objects;

public class DescontoComum extends DescontosMaisBase implements DescontosMais{
    public DescontoComum(Order order) {
        super (order);
    }

    public DescontoComum(DescontosMais desconto, Order order) {
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
