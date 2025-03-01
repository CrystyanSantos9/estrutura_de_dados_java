package cryss.dev.estrutura_de_dados_java.threadsbezzerra.basico;

import cryss.dev.estrutura_de_dados_java.threadsbezzerra.basico.executavel.Counter;

public class ExecutaThreadCount {
    public static void main(String[] args) {
        Counter resourceCounter = new Counter ();
        Thread task1 = new Thread (resourceCounter);
        Thread task2 = new Thread (resourceCounter);
        Thread task3 = new Thread (resourceCounter);
        Thread task4 = new Thread (resourceCounter);
        task1.start ();
        task2.start ();
        task3.start ();
        task4.start ();
    }
}
