package cryss.dev.estrutura_de_dados_java.chainofresponsability;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Builder
@Data
public class OrderUser {
    private String name;
    private String age;

    @Builder.Default
    private Boolean isActive = false;

    private String pass;

    @Builder.Default
    private BigDecimal cumulativeDiscount = BigDecimal.ZERO;

}
