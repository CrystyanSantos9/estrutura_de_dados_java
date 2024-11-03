package cryss.dev.estrutura_de_dados_java.patterns.mediator.OrderManagerMediator;

import java.util.ArrayList;
import java.util.List;

public class Restaurant implements RestaurantMediator {

    private List<Customer> customers;
    private List<Waiter> waiters;

    public Restaurant() {
        this.customers = new ArrayList<> ();
        this.waiters = new ArrayList<> ();
    }

    @Override
    public void takeOrder(String order, Customer customer) {
        System.out.println(customer.getName() + " pediu: " + order);
        for (Waiter waiter : waiters) {
            waiter.receiveOrder(order, customer);
        }
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void addWaiter(Waiter waiter) {
        waiters.add(waiter);
    }
}
