package cryss.dev.estrutura_de_dados_java.decorator_pricefinal;

import java.math.BigDecimal;
import java.util.List;

public interface PriceFinal {

    BigDecimal calculate();

    boolean isEligible();

    List<String> getDiscountType();
}
