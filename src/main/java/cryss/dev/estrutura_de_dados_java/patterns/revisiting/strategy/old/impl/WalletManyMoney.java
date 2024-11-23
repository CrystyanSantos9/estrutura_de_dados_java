package cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.old.impl;

import cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.domain.UserWalletInformation;
import cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.old.WalletStrategy;

public class WalletManyMoney implements WalletStrategy {
    @Override
    public String createLink(UserWalletInformation information) {
        try {

            if (information.getBirth ().minusYears (45l).getYear () >= 0) {
                return String.format ("https://wallet.discount.ap/manymoney/%s/especial=true", information.getName ());
            }
            return String.format ("https://wallet.discount.ap/nomanymoney/%s/especial=true", information.getName ());

        } catch (RuntimeException exception) {
            return String.format ("Não foi possível criar link com a data informada.", information.getBirth ());
        }
    }
}
