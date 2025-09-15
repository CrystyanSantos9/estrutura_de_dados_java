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
public class CafeEscuro extends Bebida implements Complemento {
    private String name = "Café Escuro";

    public CafeEscuro(BigDecimal price, Complemento complemento) {
        super (price, complemento);
    }

    public CafeEscuro(BigDecimal price) {
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
