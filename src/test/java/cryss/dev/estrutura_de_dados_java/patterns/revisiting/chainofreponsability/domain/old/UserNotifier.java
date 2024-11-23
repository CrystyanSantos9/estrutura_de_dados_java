package cryss.dev.estrutura_de_dados_java.patterns.revisiting.chainofreponsability.domain.old;

import cryss.dev.estrutura_de_dados_java.patterns.revisiting.chainofreponsability.domain.UserProfile;

public interface UserNotifier {
    void notify(UserProfile profile);
    void setNextNotifier(UserNotifier notifier);
}
