package cryss.dev.estrutura_de_dados_java.patterns.decorator;

import cryss.dev.estrutura_de_dados_java.patterns.decorator.discount.DiscountType;

public interface PrecoFinal {

    Long calculate();

    Long getValorDescontoApplyed();

    DiscountType getTipoDescontoApplyed();


}
