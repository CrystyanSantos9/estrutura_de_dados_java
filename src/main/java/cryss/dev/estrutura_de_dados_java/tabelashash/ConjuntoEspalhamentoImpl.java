package cryss.dev.estrutura_de_dados_java.tabelashash;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConjuntoEspalhamentoImpl implements ConjuntoEspalhamento {

    private List<List<String>> tabela = new ArrayList<List<String>> ();
    private int tamanho = 0;

    public ConjuntoEspalhamentoImpl() {
        for(int i = 0; i<26; i++){
            LinkedList<String> lista = new LinkedList<> ();
            tabela.add (lista);
        }
    }

    @Override
    public void adiciona(String palavra) {
        if (!this.contem (palavra)) {
            int indice = this.calculaIndiceDaTabela (palavra);
            List<String> lista = this.tabela.get (indice);
            lista.add (palavra);
            this.tamanho = this.tamanho + 1;
        }
    }

    @Override
    public void remove(String palavra) {
        if (this.contem (palavra)) {
            int indice = this.calculaIndiceDaTabela (palavra);
            List<String> lista = this.tabela.get (indice);
            lista.remove (palavra);
            this.tamanho = this.tamanho - 1;
        }
    }

    @Override
    public boolean contem(String palavra) {
        int indice = this.calculaIndiceDaTabela (palavra);
        List<String> lista = this.tabela.get (indice);
        return lista.contains (palavra);
    }

    @Override
    public List<String> pegaTodas() {
        List<String > palavras = new ArrayList<> ();

        for(int i = 0; i< this.tabela.size (); i++){
            palavras.addAll (this.tabela.get (i));
        }

        return palavras;
    }

    @Override
    public int tamanho() {
        return this.tamanho;
    }

    @Override
    public void imprimeTabela() {

    }

    private int calculaIndiceDaTabela(String palavra){
        return palavra.toLowerCase ().charAt (0) % 26;
    }


}
