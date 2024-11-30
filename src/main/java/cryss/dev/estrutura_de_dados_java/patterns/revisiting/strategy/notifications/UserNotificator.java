package cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.notifications;

public class UserNotificator {
    public void sendMessage(UserType userType, String message){
        userType.getNotificationSender ().send (message);
    }
}
