package cryss.dev.estrutura_de_dados_java.patterns.revisiting.strategy.notifications;

import org.junit.jupiter.api.Test;

class UserNotificatorTest {

    @Test
    void sendMessage() {
        UserType email = UserType.EMAIL;
        UserType call = UserType.CALL;
        UserType sms = UserType.EMAIL;
        UserType NOVA_LINHA = UserType.EMAIL;

        UserNotificator notificator = new UserNotificator ();

        notificator.sendMessage (email, "Para minha querida...");
        notificator.sendMessage (call, "Para minha querida...");
        notificator.sendMessage (sms, "Para minha querida...");
    }
}