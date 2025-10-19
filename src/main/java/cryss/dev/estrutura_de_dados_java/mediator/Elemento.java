package cryss.dev.estrutura_de_dados_java.mediator;

import lombok.Getter;

@Getter
public class Elemento {
    protected String name;
    protected Mediador mediador;

    public Elemento(String name) {
        this.name = name;
    }

    public void setMediador(Mediador mediador) {
        this.mediador = mediador;
    }
}
