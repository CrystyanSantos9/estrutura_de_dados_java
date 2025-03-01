package cryss.dev.estrutura_de_dados_java.threadsbezzerra.basico.executavel;

import static java.lang.System.*;

public class Counter implements Runnable{

    private int count;

    @Override
    public void run() {
        synchronized (this) {
            count++;
            out.println ("Executando na thread: " + Thread.currentThread ().getName () + ". counter: " + count);
        }
    }
}
