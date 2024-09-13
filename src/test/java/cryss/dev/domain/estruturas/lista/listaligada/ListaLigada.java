package cryss.dev.domain.estruturas.lista.listaligada;

import java.util.stream.IntStream;

public class ListaLigada {

    //Espaço em memória
    Celula primeira;
    Celula ultima;

    private int totalDeElementos;

    public void adicionaNoComeco(Object elemento) {
        //Eu armazeno a referência a esse atributo na celula
        Celula nova = new Celula (this.primeira, elemento);
        this.primeira = nova;

        if (this.totalDeElementos == 0) {
            this.ultima = this.primeira;
        }

        this.totalDeElementos++;
    }

    @Override
    public String toString(){
        if(this.totalDeElementos == 0){
            return "[]";
        }

        StringBuilder builder = new StringBuilder ("[");
        Celula atual = primeira;

        //Vai até o penúltimo elemento
        for (int i = 0; i < this.totalDeElementos - 1; i++) {
            builder.append(atual.getElemento());
            builder.append(", ");
            atual = atual.getProxima();
        }


        //após percorer todos , aí acrescento o último
        builder.append (atual.getElemento ());
        builder.append ("]");

        return builder.toString ();

    }

    public void adiciona(Object elemento){
        if(totalDeElementos==0){
            adicionaNoComeco (elemento);
        }else{
            Celula nova = new Celula(elemento);
            //Celula final = primeira logo primeira.proxima = nova
            //Para as outras, consideraremos sempre a última
            this.ultima.setProxima (nova);
            //Muda o valor da ultima
            this.ultima = nova;
            this.totalDeElementos ++;
        }
    }

    private boolean posicaoOcupada(int posicao){
        return posicao >=0 && posicao < this.totalDeElementos;
    }

    private Celula pegaCelulaAnterior(int posicao) {
        if (!this.posicaoOcupada (posicao)) {
            throw new IllegalArgumentException ("Posição não existe");
        }
        //A partir da primeira célula
        Celula atual = primeira;
        for (int i = 0; i < posicao; i++) {
            //paramos antes da posicao informada
            //atual será sempre atualizada
            atual = atual.getProxima ();
        }
        return atual;
    }

    public void adiciona(int posicao, Object elemento){
        if(posicao == 0) { // Primeira célula
            this.adicionaNoComeco (elemento);
        }else if(posicao == this.totalDeElementos){ //fim da lista
            this.adiciona (elemento);
        }else{
            Celula celulaAnterior = this.pegaCelulaAnterior (posicao-1);
            Celula novaCelula = new Celula (celulaAnterior.getProxima (), elemento);
            celulaAnterior.setProxima (novaCelula);
            this.totalDeElementos++;
        }
    }

}
