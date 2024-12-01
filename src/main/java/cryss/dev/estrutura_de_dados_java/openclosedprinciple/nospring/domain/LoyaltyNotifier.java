package cryss.dev.estrutura_de_dados_java.openclosedprinciple.nospring.domain;

public interface LoyaltyNotifier {
    String sendNotification();
    boolean accept(LoyaltyType loyaltyType);

}
