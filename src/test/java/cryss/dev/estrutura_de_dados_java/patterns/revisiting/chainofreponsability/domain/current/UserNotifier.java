package cryss.dev.estrutura_de_dados_java.patterns.revisiting.chainofreponsability.domain.current;

import cryss.dev.estrutura_de_dados_java.patterns.revisiting.chainofreponsability.domain.UserProfile;

import java.util.function.Consumer;
import java.util.function.Predicate;

public record UserNotifier(Predicate<UserProfile> predicate, Consumer<UserProfile> consumer) {
}
