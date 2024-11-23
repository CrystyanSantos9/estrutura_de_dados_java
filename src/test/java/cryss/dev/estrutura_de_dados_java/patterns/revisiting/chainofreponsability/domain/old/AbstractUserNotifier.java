package cryss.dev.estrutura_de_dados_java.patterns.revisiting.chainofreponsability.domain.old;

public abstract  class AbstractUserNotifier implements UserNotifier {
    protected UserNotifier nextNotifier;

    @Override
    public void setNextNotifier(UserNotifier notifier){this.nextNotifier = notifier;}

}
