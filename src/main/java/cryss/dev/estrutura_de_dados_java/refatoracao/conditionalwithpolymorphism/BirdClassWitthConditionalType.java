package cryss.dev.estrutura_de_dados_java.refatoracao.conditionalwithpolymorphism;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class BirdClassWitthConditionalType {

    private String name;
    private BirdType type;

    //Temos um método em nossa classe que é realizado conforme
    //a entrada de uma informação referente ao tipo de passaro

    Float getSpeed(){
        //Temos uma condicional switch que depende de um type
        //que é um valor que pode ter vários outros valores
        switch (type){
            case BirdType.BLUE_FINCH:
                return 100.00F;
            case BirdType.SAFFRON:
                return 110.00F;
            case BirdType.OWL_FINCH:
                return 200.00F;
        }
        throw new RuntimeException("Should be unreachable");
    }

}
