package cryss.dev.estrutura_de_dados_java.threadsbezzerra.basico;

import cryss.dev.estrutura_de_dados_java.threadsbezzerra.basico.executavel.PrintHelloName;

public class ExecutaThreadBasico {
    public static void main(String[] args) {
        Thread task1 = new Thread (new PrintHelloName("task1"));
        Thread task2 = new Thread (new PrintHelloName("task2"));
        Thread task3 = new Thread (new PrintHelloName("task3"));
        Thread task4 = new Thread (new PrintHelloName("task4"));
        task1.start ();
        task2.start ();
        task3.start ();
        task4.start ();
    }
}
