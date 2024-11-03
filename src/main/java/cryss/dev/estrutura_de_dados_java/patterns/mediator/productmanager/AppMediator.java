package cryss.dev.estrutura_de_dados_java.patterns.mediator.productmanager;


import cryss.dev.estrutura_de_dados_java.patterns.mediator.productmanager.command.Command;
import cryss.dev.estrutura_de_dados_java.patterns.mediator.productmanager.query.ListProductsQuery;
import cryss.dev.estrutura_de_dados_java.patterns.mediator.productmanager.query.Query;
import cryss.dev.estrutura_de_dados_java.patterns.mediator.productmanager.service.ProductService;

public class AppMediator implements Mediator {

    private ProductService service;

    public AppMediator(ProductService service) {
        this.service = service;
    }

    //O send command é um registro e execução

    @Override
    public void sendCommand(Command command) {
        command.execute();
    }


    //registro e execucao do tipo de query
    @Override
    public <T> T sendQuery(Query<T> query) {
        if (query instanceof ListProductsQuery) {
            return (T) service.listProducts();
        }
        return null;
    }
}
