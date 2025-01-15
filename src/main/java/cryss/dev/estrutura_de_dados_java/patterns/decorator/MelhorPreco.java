package cryss.dev.estrutura_de_dados_java.patterns.decorator;

import cryss.dev.estrutura_de_dados_java.patterns.decorator.discount.DiscountType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MelhorPreco extends MelhorPrecoBase implements PrecoFinal {

    private PrecoFinal precoFinal;

    public MelhorPreco() {
        setTipoDesconto (DiscountType.PMC);
    }

    public MelhorPreco(PrecoFinal precoFinal) {
        this.precoFinal = precoFinal;
        setTipoDesconto (DiscountType.PMC);
    }

    @Override
    public Long calculate() {
        if (this.tipoDesconto.getCode () == 1L) {
            this.total = valorBase - valorDesconto;
        }
        return this.calculateTotal(precoFinal);
    }

    @Override
    public Long getValorDescontoApplyed() {
        return valorDesconto;
    }

    @Override
    public DiscountType getTipoDescontoApplyed() {
        return tipoDesconto;
    }

}

