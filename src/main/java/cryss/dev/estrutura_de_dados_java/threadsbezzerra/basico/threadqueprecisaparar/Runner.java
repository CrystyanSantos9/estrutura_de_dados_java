package cryss.dev.estrutura_de_dados_java.threadsbezzerra.basico.threadqueprecisaparar;

public class Runner implements Runnable{

    public Race race;
    public String runnerName;

    public Runner(Race race, String runnerName) {
        this.race = race;
        this.runnerName = runnerName;
    }

    @Override
    public void run() {
        System.out.println (runnerName + " starts race...");

        while (!race.isFinished ()){
            race.setFinished (true);
            System.out.println ("Winner: " + runnerName);
            return;
        }

        System.out.println ("Runner : " + runnerName + " lost.");
    }
}
