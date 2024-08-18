package cryss.dev.domain.aluno;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Aluno {

    private String nome;

    @Override
    public boolean equals(Object outroAluno) {
        if (Objects.nonNull (outroAluno)
                && outroAluno instanceof Aluno outro
                && ObjectUtils.isNotEmpty (outro.getNome ())) {
            return this.nome.equals (outro.getNome ());
        }
        return false;
    }

}
