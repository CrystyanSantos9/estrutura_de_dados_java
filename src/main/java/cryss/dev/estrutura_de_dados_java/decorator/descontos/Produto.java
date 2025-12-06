package cryss.dev.estrutura_de_dados_java.decorator.descontos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;


@AllArgsConstructor
@Builder
@Getter
public class Produto implements Serializable  {
    private String name;
    @Builder.Default
    private BigDecimal preco = BigDecimal.TEN;
}
