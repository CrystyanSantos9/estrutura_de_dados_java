package cryss.dev.estrutura_de_dados_java.decorator_pricefinal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class DiscountOffer implements PriceFinal{

    private final List<String> discountType;
    private PriceFinal priceFinal;
    private final String offerType;

    public DiscountOffer(PriceFinal priceFinal) {
        this.priceFinal = priceFinal;
        this.discountType = priceFinal.getDiscountType ();
        this.offerType = "OFFER";
    }

    @Override
    public List<String> getDiscountType() {
        return discountType;
    }

    public String getOfferType() {
        return offerType;
    }

    @Override
    public BigDecimal calculate() {
        if(this.isEligible ()){
            return priceFinal.calculate ().subtract (BigDecimal.valueOf (2.00)).setScale (2, RoundingMode.HALF_DOWN);
        }
        return BigDecimal.ZERO;
    }

    @Override
    public boolean isEligible() {
        return priceFinal.getDiscountType().contains (this.getOfferType());
    }

}
