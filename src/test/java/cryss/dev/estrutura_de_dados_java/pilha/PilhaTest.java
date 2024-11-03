package cryss.dev.estrutura_de_dados_java.pilha;

import org.junit.jupiter.api.Test;

import java.util.Stack;

class PilhaTest {

    @Test
    void inserenotopodapilha(){

        Pilha<Peca> pilha = new Pilha<> ();

        Peca espelhos =  Peca.Builder
                .newInstance ()
                .withName ("espelhos").build();

        Peca roda =  Peca.Builder
                .newInstance ()
                .withName ("roda").build();

        Peca bateria =  Peca.Builder
                .newInstance ()
                .withName ("bateria").build();


        pilha.inserenotopo (espelhos);
        pilha.inserenotopo (roda);
        pilha.inserenotopo (bateria);

        Peca pecaRemovidaDoTop = pilha.removedotop ();

        System.out.println (pecaRemovidaDoTop);

        if(pilha.Isvazia ()){
            System.out.println ("A pilha está vazia");
        }

    }

    @Test
    void testaPilhaDoJava(){
        Stack<Peca> pilhadojava = new Stack<> ();

        Peca roda = Peca.Builder.newInstance ().withName ("roda").build ();

        pilhadojava.push (roda);
        System.out.println (pilhadojava.pop ());

    }

    @Test
    void testaCaminhoPercorrido(){


    }
}