package cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.services;

import cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.domain.LoyaltyNotifier;
import cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.domain.LoyaltyType;
import cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.http.STIXClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StixNotifer implements LoyaltyNotifier {


    private final STIXClient client;


    @Override
    public String sendNotification() {
            return client.getDetails ();
    }

    @Override
    public boolean accept(LoyaltyType loyaltyType) {
        return "STIX".equals (loyaltyType.getType ());
    }

}
