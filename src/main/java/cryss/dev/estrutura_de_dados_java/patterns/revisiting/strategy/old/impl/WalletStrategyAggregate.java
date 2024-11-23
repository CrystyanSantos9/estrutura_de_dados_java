package cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.old.impl;

import cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.domain.UserWalletInformation;

public class WalletStrategyAggregate {


    //Se o seu método é auto contido = não depende de estados externos ( variáveis de inicialização )
    public static String especialLink(UserWalletInformation information) {
        return "Especial";
    }

    //Se o seu método precisa de estados externos = variáveis e comportamentos externos
    public String manyMoneyLink(UserWalletInformation information) {
        return "Many money";
    }

}
