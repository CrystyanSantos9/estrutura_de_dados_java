package cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.service;

import cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.domain.UserWalletInformation;
import cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.old.WalletStrategy;
import cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.old.impl.WalletEspecialUser;
import cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.old.impl.WalletStrategyAggregate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class WalletServiceTest {
    @Test
    void createLinkEspecial() {

        //Arrange //Given
        UserWalletInformation userEspecial = UserWalletInformation.builder ().name ("vegeta").build ();
        WalletService walletService = new WalletService ();
        WalletStrategy especialStrategy = new WalletEspecialUser ();

        //Act / When
        walletService.setStrategy (especialStrategy);
        String expected = "vegeta";
        String atual = walletService.createLink (userEspecial);

        //Assert / Then
        assertTrue (atual.contains (expected));

    }

    @Test
    void createAdvancdLinkEspecial() {

        //Arrange //Given
        UserWalletInformation userEspecial = UserWalletInformation.builder ().name ("vegeta").build ();
        WalletAdvancedService walletService = new WalletAdvancedService ();


        //Act / When
        walletService.setFunction (WalletStrategyAggregate::especialLink);

        String expected = "vegeta";
        String atual = walletService.createLink (userEspecial);

        //Assert / Then
        assertTrue (atual.contains (expected));

    }
}