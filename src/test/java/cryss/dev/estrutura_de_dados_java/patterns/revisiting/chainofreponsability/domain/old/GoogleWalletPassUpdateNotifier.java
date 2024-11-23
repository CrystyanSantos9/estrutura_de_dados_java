package cryss.dev.estrutura_de_dados_java.patterns.revisiting.chainofreponsability.domain.old;

import cryss.dev.estrutura_de_dados_java.patterns.revisiting.chainofreponsability.domain.UserProfile;

public class GoogleWalletPassUpdateNotifier extends AbstractUserNotifier {
    @Override
    public void notify(UserProfile profile) {
        if (profile.hasGoogleWalletPass ()) {
            System.out.println ("Google Wallet Pass updated.");
        } else if (nextNotifier != null) {
            nextNotifier.notify (profile);
        } else {
            throw new RuntimeException ("No notification sent.");
        }
    }
}
