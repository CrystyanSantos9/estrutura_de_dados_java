package cryss.dev.estrutura_de_dados_java.patterns.revisiting.chainofreponsability.domain.current;

import cryss.dev.estrutura_de_dados_java.patterns.revisiting.chainofreponsability.domain.UserProfile;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class SMSNotifier implements Consumer<UserProfile>, Predicate<UserProfile> {
    @Override
    public void accept(UserProfile profile) {
        System.out.println ("SMS notification sent.");
    }

    @Override
    public boolean test(UserProfile profile) {
        return profile.allowsSMS ();
    }
}