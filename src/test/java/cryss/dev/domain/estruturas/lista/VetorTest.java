package cryss.dev.domain.estruturas.lista;

import cryss.dev.domain.aluno.Aluno;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.jms.JmsProperties;

import java.time.Period;
import java.time.temporal.Temporal;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class VetorTest {

    @Test
    void adicionaNoFimDalista(){
        Aluno a1 = Aluno.builder ().nome ("Thiago").build ();
        Aluno a2 =Aluno.builder ().nome ("Rodolfo").build ();

        Vetor lista = new Vetor ();

        lista.adiciona (a1);
        lista.adiciona (a2);

        System.out.println (lista);

        //lembrando que o indice inicial é 0 logo o centesimo elemento é 99
        assertEquals (lista.pega (1).getNome (), a2.getNome ());
    }

    @Test
    void adicionaNaPosicaoInformada(){
        Aluno a1 = Aluno.builder ().nome ("Thiago").build ();
        Aluno a2 =Aluno.builder ().nome ("Rodolfo").build ();

        Vetor lista = new Vetor ();

        lista.adiciona (a1);
        lista.adiciona (0, a2);
        lista.adiciona (1, a2);

        System.out.println (lista.tamanho ());

        //lembrando que o indice inicial é 0 logo o centesimo elemento é 99
        assertEquals (lista.pega (1).getNome (), a2.getNome ());
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
        assertEquals (lista.pega (2).getNome (), a1.getNome ());

    }

    @Test
    void removeAlunoNaPosicaoInformada(){
        Aluno a1 = Aluno.builder ().nome ("Thiago").build ();
        Aluno a2 =Aluno.builder ().nome ("Rodolfo").build ();

        Vetor lista = new Vetor ();

        lista.adiciona (a1);
        lista.adiciona (a1);
        lista.adiciona (a2);


        lista.remove (0);

        //A2 assume o lugar de a1 na posicao 1
        assertEquals (a2.getNome (),lista.pega (1).getNome ());

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

    @Test
    void retornaOTamanhoDaLista(){
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
      assertEquals (3, lista.tamanho ());

    }

    @Test
    void adiciona100milAlunosNoModoLinear(){

        int CEM_MIL = 100000;
        VetorComAdicionarLento vetorLinear = new VetorComAdicionarLento ();

        long inicio = System.currentTimeMillis ();
        for(int i=1; i<CEM_MIL; i++){
            Aluno aluno = Aluno.builder().build();
            vetorLinear.adiciona (aluno);
        }
        long fim =  System.currentTimeMillis ();
        double tempo = (fim - inicio)/1000.0;
        log.info ("Tempo em segundos ={}", tempo);
    }

    @Test
    void adiciona100milAlunosNoModoConstante(){

        int CEM_MIL = 100000;
        Vetor vetorConstante= new Vetor ();

        long inicio = System.currentTimeMillis ();
        for(int i=1; i<CEM_MIL; i++){
            Aluno aluno = Aluno.builder().build();
            vetorConstante.adiciona (aluno);
        }
        long fim =  System.currentTimeMillis ();
        double tempo = (fim - inicio)/1000.0;
        log.info ("Tempo em segundos ={}", tempo);
        log.info ("Lista pegando posicao ocupada  ={}", vetorConstante.pega (10));
        log.info ("Lista pegando posicao nao existente", vetorConstante.pega (100000000));
    }

    @Test
    void adicionaEstouraEspaco(){

        int CEM_MIL = 100000221;
        Vetor vetorConstante= new Vetor ();

        long inicio = System.currentTimeMillis ();
        for(int i=1; i<CEM_MIL; i++){
            Aluno aluno = Aluno.builder().build();
            vetorConstante.adiciona (aluno);
        }
        long fim =  System.currentTimeMillis ();
        double tempo = (fim - inicio)/1000.0;
        log.info ("Tempo em segundos ={}", tempo);
        log.info ("Lista pegando posicao ocupada  ={}", vetorConstante.pega (10));
    }

    @Test
    void adicionaVetorGenericoEstouraEspaco(){

        int CEM_MIL = 100000221;
        VetorGenerico<Aluno> vetorGenerico= new VetorGenerico ();

        long inicio = System.currentTimeMillis ();
        for(int i=1; i<CEM_MIL; i++){
            Aluno aluno = Aluno.builder().nome ("Rafael").build();
            vetorGenerico.adiciona (aluno);
        }

        Aluno aluno = Aluno.builder().nome ("Rafael").build();

        vetorGenerico.remove (aluno);

        long fim =  System.currentTimeMillis ();
        double tempo = (fim - inicio)/1000.0;
        log.info ("Tempo em segundos ={}", tempo);
        log.info ("Lista pegando posicao ocupada  ={}", vetorGenerico.pega (10));
    }


}