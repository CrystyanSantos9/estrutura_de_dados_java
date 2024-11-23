package cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.service;

import cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.domain.UserWalletInformation;

import java.util.function.Function;

public class WalletAdvancedService {
    private Function<UserWalletInformation, String> function;

    public String createLink(UserWalletInformation information){
        return function.apply (information);
    }

    public void setFunction(Function<UserWalletInformation, String> function){
        this.function = function;
    }
}
