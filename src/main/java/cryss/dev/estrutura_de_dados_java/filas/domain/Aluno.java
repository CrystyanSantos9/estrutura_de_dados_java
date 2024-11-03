package cryss.dev.estrutura_de_dados_java.filas.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Aluno {
    private String name;
    private int idade;
}
