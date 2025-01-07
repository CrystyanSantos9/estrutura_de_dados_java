package cryss.dev.estrutura_de_dados_java.ocpplugin.domain.plugin;

import cryss.dev.estrutura_de_dados_java.ocpplugin.domain.Loja;
import org.springframework.plugin.core.Plugin;

import java.util.ServiceLoader;

public interface NotifierPlugin {
    void notificaEx(Loja loja);

    static void notifica(Loja loja){
        ServiceLoader.load (Plugin.class)
                .forEach (notifierPlugin -> {
                    notifierPlugin.supports (loja);
                });
    }
}
