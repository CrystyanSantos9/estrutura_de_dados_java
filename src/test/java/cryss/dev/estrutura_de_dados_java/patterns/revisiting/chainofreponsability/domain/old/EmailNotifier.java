package cryss.dev.estrutura_de_dados_java.patterns.revisiting.chainofreponsability.domain.old;

import cryss.dev.estrutura_de_dados_java.patterns.revisiting.chainofreponsability.domain.UserProfile;

public class EmailNotifier extends AbstractUserNotifier {
    @Override
    public void notify(UserProfile profile) {
        if (profile.allowsEmail ()) {
            System.out.println ("Email notification!");
        } else if (nextNotifier != null) {
            nextNotifier.notify (profile);
        } else {
            throw new RuntimeException ("No notification sent.");
        }
    }
}
