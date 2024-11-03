package cryss.dev.estrutura_de_dados_java.tabelashash;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConjuntoEspalhamentoImpl <T> implements ConjuntoEspalhamento <T> {

    private List<List<T>> tabela = new ArrayList<List<T>> ();
    private int tamanho = 0;

    public ConjuntoEspalhamentoImpl() {
        for(int i = 0; i<26; i++){
            LinkedList<T> lista = new LinkedList<> ();
            tabela.add (lista);
        }
    }

    @Override
    public void adiciona(T palavra) {
        if (!this.contem (palavra)) {
            int indice = this.calculaIndiceDaTabela (palavra);
            List<T> lista = this.tabela.get (indice);
            lista.add (palavra);
            this.tamanho = this.tamanho + 1;
        }
    }

    @Override
    public void remove(T palavra) {
        if (this.contem (palavra)) {
            int indice = this.calculaIndiceDaTabela (palavra);
            List<T> lista = this.tabela.get (indice);
            lista.remove (palavra);
            this.tamanho = this.tamanho - 1;
        }
    }

    @Override
    public boolean contem(T palavra) {
        int indice = this.calculaIndiceDaTabela (palavra);
        List<T> lista = this.tabela.get (indice);
        return lista.contains (palavra);
    }

    @Override
    public List<T> pegaTodas() {
        List<T > palavras = new ArrayList<> ();

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

    private int calculaIndiceDaTabela(T palavra){
        return ((String) palavra).toLowerCase ().charAt (0) % 26;
    }


}
