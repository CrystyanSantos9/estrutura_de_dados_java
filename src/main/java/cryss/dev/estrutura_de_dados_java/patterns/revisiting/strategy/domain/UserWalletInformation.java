package cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserWalletInformation {
    private String name;
    private String id;
    private LocalDate birth;
    private String plan;
}
