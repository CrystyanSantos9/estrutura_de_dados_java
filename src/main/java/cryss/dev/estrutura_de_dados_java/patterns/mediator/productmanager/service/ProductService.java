package cryss.dev.estrutura_de_dados_java.patterns.mediator.productmanager.service;


import cryss.dev.estrutura_de_dados_java.patterns.mediator.productmanager.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> productList = new ArrayList<>();

    public void addProduct(Product product){
        productList.add (product);
    }

    public List<Product> listProducts(){
        return productList;
    }
}
