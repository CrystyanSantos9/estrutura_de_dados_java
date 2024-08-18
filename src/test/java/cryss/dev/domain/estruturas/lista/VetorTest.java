package cryss.dev.domain.estruturas.lista;

import cryss.dev.domain.aluno.Aluno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class VetorTest {

    @Test
    void adicionaNoFimDalista(){
        Aluno a1 = Aluno.builder ().nome ("Thiago").build ();
        Aluno a2 =Aluno.builder ().nome ("Rodolfo").build ();

        Vetor lista = new Vetor ();

        lista.adiciona (a1);
        lista.adiciona (a2);

        //lembrando que o indice inicial é 0 logo o centesimo elemento é 99
        assertEquals (lista.pega (98).getNome (), a2.getNome ());
    }

    @Test
    void adicionaNaPosicaoInformada(){
        Aluno a1 = Aluno.builder ().nome ("Thiago").build ();
        Aluno a2 =Aluno.builder ().nome ("Rodolfo").build ();

        Vetor lista = new Vetor ();

        lista.adiciona (a1);
        lista.adiciona (98, a2);

        //lembrando que o indice inicial é 0 logo o centesimo elemento é 99
        assertEquals (lista.pega (98).getNome (), a2.getNome ());
    }

    @Test
    void pegaUmAlunoNaPosicaoInformada(){
        Aluno a1 = Aluno.builder ().nome ("Thiago").build ();
        Aluno a2 =Aluno.builder ().nome ("Rodolfo").build ();

        Vetor lista = new Vetor ();

        lista.adiciona (a1);
        lista.adiciona (a1);
        lista.adiciona (a1);
        lista.adiciona (98, a2);

        //lembrando que o indice inicial é 0 logo o centesimo elemento é 99
        assertEquals (lista.pega (98).getNome (), a2.getNome ());
        assertEquals (lista.pega (97).getNome (), a1.getNome ());

    }

    @Test
    void removeAlunoNaPosicaoInformada(){
        Aluno a1 = Aluno.builder ().nome ("Thiago").build ();
        Aluno a2 =Aluno.builder ().nome ("Rodolfo").build ();

        Vetor lista = new Vetor ();

        lista.adiciona (a1);
        lista.adiciona (a1);
        lista.adiciona (a1);
        lista.adiciona (98, a2);

        lista.remove (97);

        //lembrando que o indice inicial é 0 logo o centesimo elemento é 99
        assertNull (lista.pega (97));

    }

    @Test
    void contemOAlunoInformado(){
        Aluno a1 = Aluno.builder ().nome ("Thiago").build ();
        Aluno a2 =Aluno.builder ().nome ("Rodolfo").build ();
        Aluno a3 =Aluno.builder ().build ();

        Vetor lista = new Vetor ();

        lista.adiciona (a1);
        lista.adiciona (a1);
        lista.adiciona (a1);
        lista.adiciona (98, a2);

        lista.remove (97);

        //lembrando que o indice inicial é 0 logo o centesimo elemento é 99
        assertTrue (lista.contem (a2));

    }
}