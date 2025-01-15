package cryss.dev.estrutura_de_dados_java.patterns.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MelhorPrecoTest {

    @Test
    void aplicaMelhorPrecoLMPM(){

        LmpmMelhorPreco lmpm = new LmpmMelhorPreco ();
        lmpm.setValorBase (5L);
        lmpm.setValorDesconto (2L);


        OfferMelhorPreco offerMelhorPreco = new OfferMelhorPreco (lmpm);
        offerMelhorPreco.setValorBase (5L);
        offerMelhorPreco.setValorDesconto (3L);


        MelhorPreco melhorPreco = new MelhorPreco (offerMelhorPreco);
        melhorPreco.setValorBase (5L);
//        melhorPreco   .setTipoDesconto (1L);
        melhorPreco      .setValorDesconto (1L);

        melhorPreco.calculate ();

        System.out.println (melhorPreco);

        assertEquals ( 3L, melhorPreco.getTotal () );

    }

}