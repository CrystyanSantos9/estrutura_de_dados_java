package cryss.dev.estrutura_de_dados_java.tabelashash;

import org.junit.jupiter.api.Test;

class ConjuntoEspalhamentoTest {

    @Test
    void testaConjuntoDePalavrasComEspalhamento() {
        ConjuntoEspalhamento conjunto = new ConjuntoEspalhamentoImpl ();

        conjunto.adiciona ("apostila");
        conjunto.adiciona ("apostila");
        conjunto.adiciona ("apostila");
        conjunto.adiciona ("caderno");
        conjunto.adiciona ("mesa");

        if (!conjunto.contem ("apostila")) {
            System.out.println ("Erro: não tem a palavra informada.");
        }

        conjunto.remove ("apostila");

        if (conjunto.contem ("apostila")) {
            System.out.println ("Erro: tem a palavra: apostila");
        }

        if (conjunto.tamanho () != 5) {
            System.out.println ("O Conjunto deveria ser 5");
        }

    }

    @Test
    void testaConjuntoDePalavrasComEspalhamentoMelhorada() {
        ConjuntoEspalhamento conjunto = new ConjuntoEspalhamentoMelhorImpl ();

        for (int i = 0; i < 100; i++) {
            conjunto.adiciona ("" + i);
        }

        conjunto.imprimeTabela ();


    }

    @Test
    void testaDesempenhoAposRedimensionamentoDinamico() {

        long inicio = System.currentTimeMillis ();

        ConjuntoEspalhamento conjunto = new ConjuntoEspalhamentoMelhorComRedimensionamentoImpl ();

        for (int i = 0; i < 50000; i++) {
            conjunto.adiciona ("palavra" + i);
        }

        for(int i =0; i < 50000; i++ ){
            conjunto.contem ("palavra" + i);
        }

        long fim = System.currentTimeMillis ();

        System.out.println (String.format ("Tempo: %s.", (fim-inicio)/1000.0));

    }

    @Test
    void testaDesempenhoAntesDoDimensionamento() {

        long inicio = System.currentTimeMillis ();

        ConjuntoEspalhamento conjunto = new ConjuntoEspalhamentoMelhorImpl ();

        for (int i = 0; i < 50000; i++) {
            conjunto.adiciona ("palavra" + i);
        }

        for(int i =0; i < 50000; i++ ){
            conjunto.contem ("palavra" + i);
        }

        long fim = System.currentTimeMillis ();

        System.out.println (String.format ("Tempo: %s.", (fim-inicio)/1000.0));

    }
}