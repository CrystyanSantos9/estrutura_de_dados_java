package cryss.dev.estrutura_de_dados_java.decorator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Optional;

@SuperBuilder
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Leite extends Bebida implements Complemento {
    private String name = "Leite";

    public Leite(BigDecimal price, Complemento complemento) {
        super (price, complemento);
    }

    public Leite(BigDecimal price) {
        super (price, null);
    }

    @Override
    public BigDecimal cost() {
        return this.price.add (Optional
                .ofNullable (complemento)
                .map (Complemento::cost)
                .orElse (BigDecimal.ZERO));
    }
}
