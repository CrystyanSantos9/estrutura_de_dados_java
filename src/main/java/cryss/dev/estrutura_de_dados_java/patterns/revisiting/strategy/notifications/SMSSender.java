package cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.notifications;

public class SMSSender implements NotificationSender{
    @Override
    public void send(String message) {
        System.out.println (String.format ("Sending %s by sms.",message));
    }
}
