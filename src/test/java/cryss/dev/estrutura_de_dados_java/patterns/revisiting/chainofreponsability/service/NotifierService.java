package cryss.dev.estrutura_de_dados_java.patterns.revisiting.chainofreponsability.service;

import cryss.dev.estrutura_de_dados_java.patterns.revisiting.chainofreponsability.domain.UserProfile;
import cryss.dev.estrutura_de_dados_java.patterns.revisiting.chainofreponsability.domain.current.EmailNotifier;
import cryss.dev.estrutura_de_dados_java.patterns.revisiting.chainofreponsability.domain.current.GoogleUserNotifier;
import cryss.dev.estrutura_de_dados_java.patterns.revisiting.chainofreponsability.domain.current.SMSNotifier;


import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class NotifierService {
    private final Stream notifiers = Stream.of (new EmailNotifier (), new GoogleUserNotifier (), new SMSNotifier ());
    void sendNotification(UserProfile profile) {
        notifiers
                .filter (n -> ((Predicate) n).test (profile))
                .findFirst ()
                .ifPresent (n -> ((Consumer) n).accept (profile));
    }

}
