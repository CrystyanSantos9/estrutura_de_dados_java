package cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.taxas;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AplicadorDeTaxasTest {

    @Test
    void processa() {
        AplicadorDeTaxas aplicadorDeTaxas = new AplicadorDeTaxas ();

        String taxa1 = "ICMS";
        String taxa2 = "PIS";

        BigDecimal juros = new BigDecimal ("0.5");

        aplicadorDeTaxas.processa (taxa1, juros);
        aplicadorDeTaxas.processa (taxa2, juros);

    }

    @Test
    void processaThrowsException() {

        AplicadorDeTaxas aplicadorDeTaxas = new AplicadorDeTaxas ();

        BigDecimal juros = new BigDecimal ("0.5");

        assertThrows (IllegalStateException.class, () -> aplicadorDeTaxas.processa ("", juros));

    }
}