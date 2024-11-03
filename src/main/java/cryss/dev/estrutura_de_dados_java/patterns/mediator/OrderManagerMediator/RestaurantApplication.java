package cryss.dev.estrutura_de_dados_java.patterns.mediator.OrderManagerMediator;

public class RestaurantApplication {
    public static void main(String[] args) {
        RestaurantMediator mediator = new Restaurant ();

        Customer customer1 = new Customer (mediator, "Ricardo");
        Customer customer2 = new Customer (mediator, "Carol");
        Waiter waiter1 = new Waiter (mediator, "Chico");
        Waiter waiter2 = new Waiter (mediator, "Eduardo");
        Waiter waiter3 = new Waiter (mediator, "Antonio");

        //O order notifica o mediator --> que notifica o garcom ( component B )
        customer2.order ("Sobremesa");
        customer1.order ("Pizza");
    }
}
