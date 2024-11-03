package cryss.dev.estrutura_de_dados_java.patterns.mediator.productmanager;

import cryss.dev.estrutura_de_dados_java.patterns.mediator.productmanager.command.Command;
import cryss.dev.estrutura_de_dados_java.patterns.mediator.productmanager.command.CreateProductCommand;
import cryss.dev.estrutura_de_dados_java.patterns.mediator.productmanager.domain.Product;
import cryss.dev.estrutura_de_dados_java.patterns.mediator.productmanager.query.ListProductsQuery;
import cryss.dev.estrutura_de_dados_java.patterns.mediator.productmanager.query.Query;
import cryss.dev.estrutura_de_dados_java.patterns.mediator.productmanager.service.ProductService;

import java.util.List;

public class ManagerApplication {
    public static void main(String[] args) {
        ProductService service = new ProductService ();
        Mediator mediator = new AppMediator (service);

        //Não faz registro no construtor, dos comandos usados
        Command commandCreatePizza = new CreateProductCommand (service,  "Pizza", 50.0d);
        Command commandCreateBolo = new CreateProductCommand (service,  "Bolo", 33.0d);

        mediator.sendCommand (commandCreateBolo);
        mediator.sendCommand (commandCreatePizza);

        //chama query
        //A acao de consulta da nome a classe de query
        Query<List<Product>> listProductQuery = new ListProductsQuery (service);
        //a execucao da query retorna o dado esperado
        List<Product> products = mediator.sendQuery (listProductQuery);

        products.forEach (System.out::println);


    }
}
