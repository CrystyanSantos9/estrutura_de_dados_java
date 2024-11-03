package cryss.dev.estrutura_de_dados_java.patterns.mediator.ChatWithMediator;

public class ConcreteUser extends User{
    public ConcreteUser(ChatMediator mediator, String name) {
        super (mediator, name);
    }

    //Notifica mediator para ele saber a quem chamar

    @Override
    public void send(String message) {
        System.out.println (this.name + " envia: " + message);
        mediator.sendMessage(message, this);
    }


    //Esse comportamento é chamado pelo mediador
    @Override
    public void receive(String message) {
        System.out.println(this.name + " recebeu: " + message);
    }
}
