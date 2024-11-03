package cryss.dev.estrutura_de_dados_java.patterns.mediator.productmanager.query;

import cryss.dev.estrutura_de_dados_java.patterns.mediator.productmanager.domain.Product;
import cryss.dev.estrutura_de_dados_java.patterns.mediator.productmanager.service.ProductService;

import java.util.List;

public class ListProductsQuery implements Query<List<Product>>{
    private ProductService service;

    public ListProductsQuery(ProductService service){
        this.service = service;
    }
}
