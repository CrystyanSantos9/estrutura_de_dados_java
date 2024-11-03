package cryss.dev.estrutura_de_dados_java.patterns.mediator.productmanager.command;

import cryss.dev.estrutura_de_dados_java.patterns.mediator.productmanager.domain.Product;
import cryss.dev.estrutura_de_dados_java.patterns.mediator.productmanager.service.ProductService;

public class CreateProductCommand implements Command{

    private ProductService service;
    private String name;
    private double price;

    public CreateProductCommand(ProductService service, String name, double price) {
        this.service = service;
        this.name = name;
        this.price = price;
    }

    @Override
    public void execute() {
        service.addProduct(new Product (name, price));
    }
}
