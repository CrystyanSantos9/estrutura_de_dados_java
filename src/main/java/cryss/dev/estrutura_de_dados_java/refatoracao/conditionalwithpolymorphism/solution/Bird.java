package cryss.dev.estrutura_de_dados_java.refatoracao.conditionalwithpolymorphism.solution;

import cryss.dev.estrutura_de_dados_java.refatoracao.conditionalwithpolymorphism.BirdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@AllArgsConstructor
@Getter
@SuperBuilder
public abstract class Bird {

    //usamos a classe abstrata para deixar comportamentos comuns
    //ou usamos interfaces para indicar os  varios tipos de bird
    //e aí cada tipo de bird, implementa o seu speed.

    private String name;

    public abstract Float getSpeed();

}
