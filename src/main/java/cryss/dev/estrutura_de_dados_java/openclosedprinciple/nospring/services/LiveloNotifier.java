package cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.services;

import cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.domain.LoyaltyNotifier;
import cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.domain.LoyaltyType;
import cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.http.LiveloClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LiveloNotifier implements LoyaltyNotifier {

    private final LiveloClient client;

    @Override
    public String sendNotification() {
        return client.getDetails ();
    }

    @Override
    public boolean accept(LoyaltyType loyaltyType) {
        return "LIVELO".equals (loyaltyType.getType ());
    }
}
