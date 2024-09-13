package cryss.dev.estrutura_de_dados_java.category_tree;

import com.fasterxml.jackson.core.JsonProcessingException;
import cryss.dev.estrutura_de_dados_java.utils.JSONSerializer;
import lombok.Builder;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


public class Category {

    private String name;


    private List<Category> subcategories;


    //Só inicializo espaço na lista de categorias quando crio a categoria
    @Builder
    public Category(String name) {
        this.name = name;
        this.subcategories = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Category> getSubcategories() {
        return subcategories;
    }

    public void addSubcategory(Category subcategory){
        this.subcategories.add (subcategory);
    }

    @Override
    public String toString(){
        try {
            return JSONSerializer.toString (this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException (e);
        }
    }
}
