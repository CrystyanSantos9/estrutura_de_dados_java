package cryss.dev.estrutura_de_dados_java.decorator_pricefinal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

class BasePriceTest {

    @Test
    void calculateOffer(){
        List<String> offersEnables = List.of ("OFFER", "LMPM");
        PriceFinal base = new BasePrice (BigDecimal.TEN, offersEnables);
        PriceFinal offer = new DiscountOffer (base);
        PriceFinal lmpm = new DiscountLmpm(offer);

        Assertions.assertEquals (new BigDecimal ("6.00"), lmpm.calculate ());

    }

}