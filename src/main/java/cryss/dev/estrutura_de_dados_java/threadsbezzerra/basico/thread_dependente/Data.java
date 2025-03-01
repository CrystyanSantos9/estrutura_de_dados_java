package cryss.dev.estrutura_de_dados_java.threadsbezzerra.basico.thread_dependente;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Data {
    private boolean outOfSync;
    private int value;

    public synchronized void sync() {
        System.out.println ("Syncronizing data...");

        try {
            if (!outOfSync) {
                System.out.println ("data is not out of sync...");
                this.wait ();
            }

            outOfSync = false;
            Thread.sleep (2000);
            System.out.println ("Syncronized!");
            this.notifyAll ();
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    public synchronized void read() {
        System.out.println ("Reading data...");
        try {
            if (outOfSync) {
                System.out.println ("waiting sync...");
                this.wait ();
            }

            Thread.sleep (3000);
            System.out.println ("Finally reading data: " + value);

        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

}
