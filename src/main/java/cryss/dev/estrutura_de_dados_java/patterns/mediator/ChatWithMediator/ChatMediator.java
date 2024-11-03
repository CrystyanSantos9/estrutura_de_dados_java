package cryss.dev.estrutura_de_dados_java.patterns.mediator.ChatWithMediator;

public interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}
