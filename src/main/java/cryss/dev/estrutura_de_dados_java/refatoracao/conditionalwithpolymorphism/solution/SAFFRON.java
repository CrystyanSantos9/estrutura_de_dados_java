package cryss.dev.estrutura_de_dados_java.refatoracao.conditionalwithpolymorphism.solution;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class SAFFRON extends Bird{
    @Override
    public Float getSpeed() {
        return 110.00F;
    }

}
