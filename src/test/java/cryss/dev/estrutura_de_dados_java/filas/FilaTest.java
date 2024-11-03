package cryss.dev.estrutura_de_dados_java.filas;

import cryss.dev.estrutura_de_dados_java.filas.domain.Aluno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class FilaTest {

    private Aluno aluno;

    @BeforeEach
    void setup(){
       aluno = Aluno.builder ().name ("Carlos").idade (11).build ();
    }

    @Test
    void testaFila() {

        Fila<Aluno> fila = new FilaImpl();
        Fila<String> filaDeString  = new FilaImpl();



        fila.insere (aluno);
        filaDeString.insere ("Elemento 1");

        Aluno alunoRemovido = fila.remove ();

        if (fila.vazia ()) {
            System.out.println ("a fila está vazia");
        }

        if(filaDeString.vazia () == false){
            System.out.println ("a fila não está vazia");
        }

    }

    @Test
    void testaFiladoJava(){
        Queue<Aluno> filadealuno = new LinkedList<> ();

        filadealuno.add (aluno);

        Aluno alunoRemovido = filadealuno.poll ();

        System.out.println (alunoRemovido);

        if(filadealuno.isEmpty ()){
            System.out.println ("Fila vazia. ");
        }
    }

    @Test
    void testaPerformanceFiladoJavaComLinkedList() {
        Queue<Aluno> fila1 = new LinkedList<> ();
        Queue<Aluno> fila2 = new ArrayDeque();

        int numeroDeElementos = 40000;

        //Adicionando

        long inicio = System.currentTimeMillis ();

        for (int i = 0; i < numeroDeElementos; i++) {
            fila1.add (aluno);
        }

        long fim = System.currentTimeMillis ();

        System.out.println ("Adição com LinkedList na queue: " + (fim - inicio) / 1000.0);

    }

    @Test
    void testaPerformanceFiladoJavaComArrayDeque() {
        Queue<Aluno> fila1 = new ArrayDeque();

        int numeroDeElementos = 40000;

        //Adicionando

        long inicio = System.currentTimeMillis ();

        for (int i = 0; i < numeroDeElementos; i++) {
            fila1.add (aluno);
        }

        long fim = System.currentTimeMillis ();

        System.out.println ("Adição com LinkedList na queue: " + (fim - inicio) / 1000.0);

    }

}