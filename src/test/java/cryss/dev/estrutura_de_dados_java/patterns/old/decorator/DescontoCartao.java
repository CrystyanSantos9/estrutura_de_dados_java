package cryss.dev.estrutura_de_dados_java.patterns.old.decorator;

import java.math.BigDecimal;

public class DescontoCartao extends Condimento {

    private Bebida bebida;

    public DescontoCartao(Bebida bebida) {
        this.bebida = bebida;
    }

    @Override
    public String getDescription() {
        return bebida.getDescription () + ", com desconto cartão.";
    }

    @Override
    public BigDecimal cost() {
        return bebida.cost ().subtract (new BigDecimal ("0.55"));
    }
}
