package cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.taxas;

import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;

import java.math.BigDecimal;

public interface Taxa {
    BigDecimal aplicaJuros(BigDecimal juros);

    @SneakyThrows
    static Taxa geraTaxa(String taxa) {
        if (!ObjectUtils.isNotEmpty (taxa)) {
            throw new IllegalStateException ("Valores de entrada incorretos.");
        }
        Object instancia = Class.forName ("cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.taxas." + taxa).newInstance ();
        Taxa taxaAplicada = (Taxa) instancia;
        return taxaAplicada;
    }
}
