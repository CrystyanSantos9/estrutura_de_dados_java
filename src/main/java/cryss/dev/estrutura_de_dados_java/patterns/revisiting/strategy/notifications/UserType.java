package cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.notifications;

public enum UserType {

    EMAIL (new EmailSender ()),
    SMS (new SMSSender ()),
    CALL (new CallSender ());

private NotificationSender notificationSender;

    UserType(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    public NotificationSender getNotificationSender() {
        return notificationSender;
    }

}
