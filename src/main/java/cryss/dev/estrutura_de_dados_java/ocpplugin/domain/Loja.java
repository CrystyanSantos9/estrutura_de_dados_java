package cryss.dev.estrutura_de_dados_java.ocpplugin.domain;

import lombok.Getter;

@Getter
public enum Loja {

    ABC("ABC"),
    DO_BAU("DO_BAU"),
    VAMOLA("VAMOLA");

    private String description;

    Loja(String description){
        this.description = description;
    }

}
