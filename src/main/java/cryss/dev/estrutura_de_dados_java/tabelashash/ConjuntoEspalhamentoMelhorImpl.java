package cryss.dev.estrutura_de_dados_java.tabelashash;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConjuntoEspalhamentoMelhorImpl <T> implements ConjuntoEspalhamento <T> {

    private List<List<T>> tabela = new ArrayList<List<T>> ();
    private int tamanho = 0;

    public ConjuntoEspalhamentoMelhorImpl() {
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
            //no registro zero insira a lista
            //inserimos listas, não só elementos
            //vai ficar um único array
            palavras.addAll (this.tabela.get (i));
        }

        return palavras;
    }

    @Override
    public int tamanho() {
        return this.tamanho;
    }

//    private int calculaCodigoDeEspalhamento(T palavra){
//        int codigo = 1;
//        for(int i = 0; i<palavra.length (); i++){
//            codigo = 31 * codigo + palavra.charAt (i);
//        }
//        return codigo;
//    }

    private int calculaIndiceDaTabela(T palavra){
        int codigoDeEspalhamento = palavra.hashCode ();
        codigoDeEspalhamento = Math.abs (codigoDeEspalhamento);
        return codigoDeEspalhamento % this.tabela.size ();
    }

    public void imprimeTabela(){
        for(List<T> lista: this.tabela){
            System.out.println ("[");
            for(int i = 0; i<lista.size (); i++){
                System.out.println ("*");
            }
            System.out.println ("]");
        }
    }


    private void redimensionaTabela(int novaCapacidade){
        List<T> palavras = this.pegaTodas ();
        this.tabela.clear ();

        for(int i=0; i< novaCapacidade; i++){
            this.tabela.add (new LinkedList<T> ());
        }

        for(T palavra: palavras){
            this.adiciona (palavra);
        }
    }

    private void verificaCarga(){
        int capacidadeAtual = this.tabela.size ();
        System.out.println ("Capacidade atual: " + capacidadeAtual);
        System.out.println ("Quantidade de elementos: " + this.tamanho);
        double carga = (double) this.tamanho / capacidadeAtual;
        System.out.println ("Carga: " + carga);

        if(carga>0.75){
            System.out.println ("Aumentando carga para: " + carga * 2);
            this.redimensionaTabela (capacidadeAtual*2);
        }else if(carga<0.25){
            System.out.println ("Diminuindo carga para: " + carga / 2);
            this.redimensionaTabela (Math.max (capacidadeAtual/2, 10));
        }
    }


}
