package cryss.dev.estrutura_de_dados_java.patterns.decorator;

import cryss.dev.estrutura_de_dados_java.patterns.decorator.discount.DiscountType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LmpmMelhorPreco extends MelhorPrecoBase implements PrecoFinal{

    private PrecoFinal precoFinal;

    public LmpmMelhorPreco() {
        setTipoDesconto (DiscountType.LMPM);
    }

    public LmpmMelhorPreco(PrecoFinal precoFinal){
        this.precoFinal = precoFinal;
        setTipoDesconto (DiscountType.LMPM);
    }

    @Override
    public Long calculate() {
        if(tipoDesconto.getCode () == 2){
            this.total = valorBase - valorDesconto;
        }
        return  this.calculateTotal (precoFinal);
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
