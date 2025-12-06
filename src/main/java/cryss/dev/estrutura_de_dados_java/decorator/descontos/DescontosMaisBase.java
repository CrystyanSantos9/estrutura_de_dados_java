package cryss.dev.estrutura_de_dados_java.decorator.descontos;

import java.math.BigDecimal;

public abstract class DescontosMaisBase {
    protected DescontosMais desconto;
    protected Order order;

    public DescontosMaisBase(Order order) {
        this.order = order;
    }

    public DescontosMaisBase(DescontosMais desconto, Order order) {
        this.desconto = desconto;
        this.order = order;
    }
}
