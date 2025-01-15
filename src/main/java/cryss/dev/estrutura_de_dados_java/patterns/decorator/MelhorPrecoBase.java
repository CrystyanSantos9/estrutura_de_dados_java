package cryss.dev.estrutura_de_dados_java.patterns.decorator;

import cryss.dev.estrutura_de_dados_java.patterns.decorator.discount.DiscountType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class MelhorPrecoBase {

    protected  Long valorBase;
    protected  Long valorDesconto;
    protected DiscountType tipoDesconto;
    protected  Long total;

    public Long calculateTotal(PrecoFinal precoFinal){
        if(precoFinal == null){
            return total;
        }else {
            if(this.total < precoFinal.calculate ()){
                return this.total;
            }
            this.total = precoFinal.calculate ();
            this.tipoDesconto = precoFinal.getTipoDescontoApplyed ();
            this.valorDesconto = precoFinal.getValorDescontoApplyed ();
            return  this.total;
        }
    }

    @Override
    public String toString() {
        return "MelhorPrecoBase{" +
                "valorBase=" + valorBase +
                ", valorDesconto=" + valorDesconto +
                ", tipoDesconto=" + tipoDesconto +
                ", total=" + total +
                '}';
    }
}
