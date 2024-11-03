package cryss.dev.estrutura_de_dados_java.patterns.mediator.OrderManagerMediator;

public class Customer {
    private RestaurantMediator mediator;
    private String name;

    public Customer(RestaurantMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
        //já registro o customer no mediator
        mediator.addCustomer (this);
    }

    public String getName() {
        return name;
    }

    public void order(String order) {
        mediator.takeOrder(order, this);
    }

}
