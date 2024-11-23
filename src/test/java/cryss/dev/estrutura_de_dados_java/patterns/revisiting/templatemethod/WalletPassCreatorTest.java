package cryss.dev.estrutura_de_dados_java.patterns.revisiting.templatemethod;

import cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.domain.UserWalletInformation;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WalletPassCreatorTest {

    public static WalletPassCreator getWalletPassCreator() {
        return new WalletPassCreator (information -> {
            return Map.of ("especial", "MVP");
        });
    }

    @Test
    void authenticateEspecialMembers() {
        //Arrange
        UserWalletInformation userEspecial = UserWalletInformation.builder ().name ("vegeta").build ();
        //Act | Assert
        getWalletPassCreator ().createPass (userEspecial);
    }

}