package cryss.dev.estrutura_de_dados_java.patterns.decorator.discount;

import lombok.Getter;

@Getter
public enum DiscountType {

    LMPM(2L),
    OFFER(3L),
    PMC(1L);

    private Long code;

    DiscountType(Long code) {
        this.code = code;
    }

}
