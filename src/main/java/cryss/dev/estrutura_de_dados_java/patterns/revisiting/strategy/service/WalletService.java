package cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.service;

import cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.domain.UserWalletInformation;
import cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.old.WalletStrategy;

public class WalletService {
    private WalletStrategy strategy;

    public String createLink(UserWalletInformation information){
        return strategy.createLink (information);
    }

    public void setStrategy(WalletStrategy strategy){
        this.strategy = strategy;
    }
}
