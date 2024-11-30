package cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.taxas;

import java.math.BigDecimal;

public class AplicadorDeTaxas {

    private BigDecimal impostoRecolhido = BigDecimal.ZERO;

    public void processa(String taxa, BigDecimal juros){
            var sum = this.impostoRecolhido.add (Taxa.geraTaxa (taxa).aplicaJuros (juros));
            this.impostoRecolhido = sum;
            System.out.println (impostoRecolhido);
    }
}
