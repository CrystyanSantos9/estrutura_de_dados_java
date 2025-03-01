package cryss.dev.estrutura_de_dados_java.threadsbezzerra.basico.thread_dependente;

public class ThreadReadData implements Runnable {

    private Data data;

    public ThreadReadData(Data data) {
        super();
        this.data = data;
    }

    @Override
    public void run() {
        data.read ();
    }
}
