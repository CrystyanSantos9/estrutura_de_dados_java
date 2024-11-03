package cryss.dev.estrutura_de_dados_java.patterns.mediator.OrderManagerMediator;

public interface RestaurantMediator {
    void takeOrder(String order, Customer customer);
    void addCustomer(Customer customer);
    void addWaiter(Waiter waiter);
}
