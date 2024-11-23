package cryss.dev.estrutura_de_dados_java.patterns.revisiting.chainofreponsability.domain.old;

import cryss.dev.estrutura_de_dados_java.patterns.revisiting.chainofreponsability.domain.UserProfile;

import java.util.Objects;

public class SMSNotifier extends AbstractUserNotifier {
    @Override
    public void notify(UserProfile profile) {
        if (profile.allowsSMS ()) {
            System.out.println ("SMS was sent.");
        } else if (Objects.nonNull (nextNotifier)) {
            nextNotifier.notify (profile);
        } else {
            throw new RuntimeException ("No notification sent.");
        }
    }
}
