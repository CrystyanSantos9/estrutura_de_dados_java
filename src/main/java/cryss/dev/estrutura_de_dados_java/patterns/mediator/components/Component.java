package cryss.dev.estrutura_de_dados_java.patterns.mediator.components;

import cryss.dev.estrutura_de_dados_java.patterns.mediator.mediator.Mediator;

public interface Component {
    void setMediator(Mediator mediator);
    String getName();
}
