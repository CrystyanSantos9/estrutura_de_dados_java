package cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LoyaltyType {

    STIX("STIX"),
    LIVELO("LIVELO");

    private final String type;

}
