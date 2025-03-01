package cryss.dev.estrutura_de_dados_java.decorator_pricefinal;

import java.math.BigDecimal;
import java.util.List;

public class BasePrice implements PriceFinal {

    private final List<String> discountType;
    private BigDecimal price;

    public BasePrice(BigDecimal price, List<String> discountType) {
        this.discountType = discountType;
        this.price = price;
    }

    @Override
    public List<String> getDiscountType() {
        return discountType;
    }

    @Override
    public BigDecimal calculate() {
        return price;
    }

    @Override
    public boolean isEligible() {
        return false;
    }

}
