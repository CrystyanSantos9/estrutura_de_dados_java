package cryss.dev.estrutura_de_dados_java.patterns.old.decorator;

import java.math.BigDecimal;

public abstract class Bebida {
    protected String description = "Bebida sem descrição.";

    public abstract BigDecimal cost();

    public String getDescription() {
        return description;
    }
}
