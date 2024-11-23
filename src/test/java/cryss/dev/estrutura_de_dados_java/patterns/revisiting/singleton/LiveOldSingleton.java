package cryss.dev.estrutura_de_dados_java.patterns.revisiting.singleton;

public class LiveOldSingleton {
    private final static LiveOldSingleton INSTANCE = new LiveOldSingleton ();

    public static LiveOldSingleton getInstance() { return INSTANCE;}
}
