package cryss.dev.domain.estruturas.lista.listaligada;

import cryss.dev.domain.aluno.Aluno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaLigadaTest {


    @Test
    void insereNoComecoDalista(){
        Aluno aluno = Aluno.builder ()
                .nome ("Gustavo")
                .build ();

        ListaLigada listaLigada = new ListaLigada ();
        listaLigada.adicionaNoComeco (aluno);

        System.out.println (listaLigada);

    }

    @Test
    void insereNoFinalDaLista(){
        Aluno aluno1 = Aluno.builder ()
                .nome ("Gustavo")
                .build ();

        Aluno aluno2 = Aluno.builder ()
                .nome ("Rafael")
                .build ();

        Aluno aluno3 = Aluno.builder ()
                .nome ("Paulo")
                .build ();

        ListaLigada listaLigada = new ListaLigada ();
        listaLigada.adiciona (aluno1);
        listaLigada.adiciona (aluno2);
        listaLigada.adiciona (aluno3);

        System.out.println (listaLigada);

    }

    @Test
    void insereNaPosicaoInformada(){
        Aluno aluno1 = Aluno.builder ()
                .nome ("Gustavo")
                .build ();

        Aluno aluno2 = Aluno.builder ()
                .nome ("Rafael")
                .build ();

        Aluno aluno3 = Aluno.builder ()
                .nome ("Paulo")
                .build ();

        Aluno aluno4 = Aluno.builder ()
                .nome ("Sergio")
                .build ();


        ListaLigada listaLigada = new ListaLigada ();
        listaLigada.adiciona (aluno1);
        listaLigada.adiciona (aluno2);
        listaLigada.adiciona (aluno3);
        listaLigada.adiciona (1, aluno4);

        System.out.println (listaLigada);

    }


}