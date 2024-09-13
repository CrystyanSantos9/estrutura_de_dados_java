package cryss.dev.estrutura_de_dados_java.refatoracao.conditionalwithpolymorphism.solution;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class European extends Bird{
    @Override
    public Float getSpeed() {
        return 100.00F;
    }

}
