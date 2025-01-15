package cryss.dev.estrutura_de_dados_java.patterns.decorator;

import cryss.dev.estrutura_de_dados_java.patterns.decorator.discount.DiscountType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OfferMelhorPreco extends MelhorPrecoBase implements PrecoFinal {

    private PrecoFinal precoFinal;

    public OfferMelhorPreco() {
        setTipoDesconto (DiscountType.PMC);
    }

    public OfferMelhorPreco(PrecoFinal precoFinal){
        this.precoFinal = precoFinal;
        setTipoDesconto (DiscountType.OFFER);
    }

    @Override
    public Long calculate() {
        if(tipoDesconto.getCode () == 3){
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
