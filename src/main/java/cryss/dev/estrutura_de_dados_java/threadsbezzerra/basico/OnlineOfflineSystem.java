package cryss.dev.estrutura_de_dados_java.threadsbezzerra.basico;

import cryss.dev.estrutura_de_dados_java.threadsbezzerra.basico.thread_dependente.Data;
import cryss.dev.estrutura_de_dados_java.threadsbezzerra.basico.thread_dependente.ThreadReadData;
import cryss.dev.estrutura_de_dados_java.threadsbezzerra.basico.thread_dependente.ThreadSyncData;

public class OnlineOfflineSystem {
    public static void main(String[] args) {
        Data data = new Data ();

//        data.setOutOfSync (true);

        Thread readData = new Thread (new ThreadReadData (data));
        Thread syncData = new Thread (new ThreadSyncData (data));

        readData.start ();

        syncData.setDaemon (true);
        syncData.start ();
    }
}
