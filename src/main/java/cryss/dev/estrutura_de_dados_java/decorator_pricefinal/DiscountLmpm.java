package cryss.dev.estrutura_de_dados_java.decorator_pricefinal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class DiscountLmpm implements PriceFinal {

    private final List<String> discountType;
    private PriceFinal priceFinal;
    private final String offerType;

    public DiscountLmpm(PriceFinal priceFinal) {
        this.priceFinal = priceFinal;
        this.discountType = priceFinal.getDiscountType ();
        this.offerType = "LMPM";
    }

    @Override
    public BigDecimal calculate() {
        if(this.isEligible ()){
            return priceFinal.calculate ().subtract (BigDecimal.valueOf (2.00)).setScale (2, RoundingMode.HALF_DOWN);
        }
        return BigDecimal.ZERO;
    }

    public String getOfferType() {
        return this.offerType;
    }

    @Override
    public boolean isEligible() {
        return priceFinal.getDiscountType().contains (this.getOfferType());
    }

    @Override
    public List<String> getDiscountType() {
        return this.discountType;
    }

}
