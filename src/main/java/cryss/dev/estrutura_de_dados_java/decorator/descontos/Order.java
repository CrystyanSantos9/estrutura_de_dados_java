package cryss.dev.estrutura_de_dados_java.decorator.descontos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Order implements Serializable {
    private String quemSolicitou;
    private Long qtd;
    private Produto produto;
    private DescontosEnum desconto;
    @Builder.Default
    private BigDecimal descontoAcumulado = BigDecimal.ZERO;

    @Override
    public String toString() {
        try {
            return JsonUtils.convert (this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException (e);
        }
    }

    @JsonGetter(value = "total")
    private BigDecimal calculateTotal(){
        BigDecimal calculatedTotal = BigDecimal.valueOf (qtd).multiply (produto.getPreco ());
        return calculatedTotal;
    }

}
