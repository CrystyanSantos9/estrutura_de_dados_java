package cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.taxas;

import java.math.BigDecimal;

public class PIS implements Taxa{
    @Override
    public BigDecimal aplicaJuros(BigDecimal juros) {
        return BigDecimal.valueOf (10L).multiply (juros);
    }
}
