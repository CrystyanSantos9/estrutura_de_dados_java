package cryss.dev.estrutura_de_dados_java.patterns.mediator.productmanager.domain;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Produto: " + name + ", Preço: " + price;
    }
}
