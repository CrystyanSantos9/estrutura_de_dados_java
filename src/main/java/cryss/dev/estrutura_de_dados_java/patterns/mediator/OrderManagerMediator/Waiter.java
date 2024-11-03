package cryss.dev.estrutura_de_dados_java.patterns.mediator.OrderManagerMediator;

public class Waiter {
    private RestaurantMediator mediator;
    private String name;

    public Waiter(RestaurantMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
        //registra o garçom
        mediator.addWaiter(this);
    }

    public void receiveOrder(String order, Customer customer) {
        System.out.println(this.name + " recebeu o pedido de " + customer.getName() + ": " + order);
        // Aqui, normalmente, enviaria o pedido para a cozinha.
    }

}
