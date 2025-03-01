package cryss.dev.estrutura_de_dados_java.threadsbezzerra.basico.threadqueprecisaparar;

public class Race {

    private volatile boolean finished;

    public boolean isFinished(){
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

}
