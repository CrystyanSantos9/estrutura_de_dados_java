package cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.services;

import cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.domain.LoyaltyNotifier;
import cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.domain.LoyaltyType;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Log4j2
@Service
public class LoyaltyNotificationService {

    private final List<LoyaltyNotifier> notifiers;


    public void sendNotification(LoyaltyType loyaltyType) {
        LoyaltyNotifier sender = notifiers.stream ()
                .filter (notifier -> notifier.accept (loyaltyType))
                .findAny ()
                .orElseThrow (() -> new IllegalStateException ("Tipo de fidelidade não disponível" + loyaltyType));


        log.info ("Client response: {}",  sender.sendNotification ());
    }

}
