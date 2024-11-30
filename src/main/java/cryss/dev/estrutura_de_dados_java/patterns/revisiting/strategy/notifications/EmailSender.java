package cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.notifications;

public class EmailSender implements NotificationSender{
    @Override
    public void send(String message) {
        System.out.println (String.format ("Sending %s by email.",message));
    }
}
