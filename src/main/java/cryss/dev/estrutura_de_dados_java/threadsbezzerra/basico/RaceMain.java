package cryss.dev.estrutura_de_dados_java.threadsbezzerra.basico;

import cryss.dev.estrutura_de_dados_java.threadsbezzerra.basico.threadqueprecisaparar.Race;
import cryss.dev.estrutura_de_dados_java.threadsbezzerra.basico.threadqueprecisaparar.Runner;

public class RaceMain {
    public static void main(String[] args) {
        Race race = new Race ();

        Thread runner1 = new Thread (new Runner (race, " 1"));
        Thread runner2 = new Thread (new Runner (race, " 2"));
        Thread runner3 = new Thread (new Runner (race, " 3"));
        Thread runner4 = new Thread (new Runner (race, " 4"));
        Thread runner5 = new Thread (new Runner (race, " 5"));
        Thread runner6 = new Thread (new Runner (race, " 6"));
        Thread runner7 = new Thread (new Runner (race, " 7"));
        Thread runner8 = new Thread (new Runner (race, " 8"));
        Thread runner9 = new Thread (new Runner (race, " 9"));
        Thread runner10 = new Thread (new Runner (race, " 10"));
        Thread runner11 = new Thread (new Runner (race, " 11"));

            runner1.start ();
            runner2.start ();
        runner3.start ();
        runner4.start ();
        runner5.start ();
        runner6.start ();
        runner7.start ();
        runner8.start ();
        runner9.start ();
        runner10.start ();
        runner11.start ();


    }
}
