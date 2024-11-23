package cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.old;

import cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.domain.UserWalletInformation;

public interface WalletStrategy {
    String createLink(UserWalletInformation information);
}
