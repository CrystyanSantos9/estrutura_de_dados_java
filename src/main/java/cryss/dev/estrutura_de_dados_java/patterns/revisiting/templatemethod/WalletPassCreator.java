package cryss.dev.estrutura_de_dados_java.patterns.revisiting.templatemethod;

import cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.domain.UserWalletInformation;

import java.util.Map;
import java.util.function.Function;

public class WalletPassCreator {
    private final Function<UserWalletInformation, Map<String, String>> strategy;

    public WalletPassCreator(Function<UserWalletInformation, Map<String, String>> strategy) {
        this.strategy = strategy;
    }

    protected void authenticate() {
        System.out.println ("Authenticating...");
    }

    public void createPass(UserWalletInformation information) {
        authenticate ();
        Map<String, String> map = strategy.apply (information);
        System.out.println (signToken (map));
    }

    protected String signToken(Map<String, String> properties) {
        return properties.values ().stream ().findFirst ().get ();
    }
}
