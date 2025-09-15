package cryss.dev.estrutura_de_dados_java.decorator;

import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.math.RoundingMode;

@SuperBuilder
public abstract class Bebida {
    protected String name = "Bebida ";
    protected BigDecimal price;
    protected Complemento complemento;

    public Bebida(BigDecimal price, Complemento complemento) {
        this.price = price.setScale(2, RoundingMode.HALF_UP);
        this.complemento = complemento;
    }

}
