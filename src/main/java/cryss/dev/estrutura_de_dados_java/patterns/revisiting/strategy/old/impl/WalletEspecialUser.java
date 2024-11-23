package cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.old.impl;

import cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.domain.UserWalletInformation;
import cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.old.WalletStrategy;

public class WalletEspecialUser implements WalletStrategy {
    @Override
    public String createLink(UserWalletInformation information) {
        if ("vegeta".equalsIgnoreCase (information.getName ())) {
            return "https://wallet.discount.ap/vegeta/especial=true";
        }
        return String.format ("https://wallet.discount.ap/%s/normal=true", information.getName ());
    }
}
