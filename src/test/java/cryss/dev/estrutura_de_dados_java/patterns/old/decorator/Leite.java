package cryss.dev.estrutura_de_dados_java.patterns.old.decorator;

import java.math.BigDecimal;

public class Leite extends Condimento {

private Bebida bebida;

    public Leite(Bebida bebida) {
        this.bebida = bebida;
    }

    @Override
    public String getDescription() {
        return bebida.getDescription () + ", Mocha.";
    }

    @Override
    public BigDecimal cost() {
        return this.bebida.cost ().add (new BigDecimal ("1.50"));
    }
}
