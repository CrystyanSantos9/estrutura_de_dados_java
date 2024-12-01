package cryss.dev.estrutura_de_dados_java.patterns.old.decorator;

import java.math.BigDecimal;

public class CafeMineiro extends Bebida{

    private final BigDecimal unitPrice = BigDecimal.valueOf (15L);

    public CafeMineiro() {
        this.description = "Expresso";
    }

    @Override
    public BigDecimal cost() {
        return unitPrice;
    }
}
