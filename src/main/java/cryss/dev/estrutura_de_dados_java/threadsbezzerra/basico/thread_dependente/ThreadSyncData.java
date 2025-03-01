package cryss.dev.estrutura_de_dados_java.threadsbezzerra.basico.thread_dependente;

public class ThreadSyncData implements Runnable {

    private Data data;

    public ThreadSyncData(Data data) {
        super();
        this.data = data;
    }

    @Override
    public void run() {
        data.sync ();
    }
}
