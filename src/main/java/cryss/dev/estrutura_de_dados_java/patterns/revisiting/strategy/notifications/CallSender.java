package cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.notifications;

public class CallSender implements NotificationSender{
    @Override
    public void send(String message) {
        System.out.println (String.format ("Sending %s  by call.",message));
    }
}
