package cryss.dev.estrutura_de_dados_java.pilha;

import java.util.LinkedList;

public class Pilha<T> {

    //O Fim da lista será o topo
    private LinkedList<T> pilha = new LinkedList<> ();


    public void inserenotopo(T peca) {
        //O método add vai adicionar no fim da lista
        this.pilha.add (peca);
    }

    public T removedotop() {
        //remove do final = o final é topo
        return this.pilha.remove (this.pilha.size ()-1);
    }
//
    public boolean Isvazia() {
        return this.pilha.size () == 0;
    }

}
