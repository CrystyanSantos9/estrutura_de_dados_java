package cryss.dev.estrutura_de_dados_java.category_tree;

import com.fasterxml.jackson.core.JsonProcessingException;
import cryss.dev.estrutura_de_dados_java.utils.JSONSerializer;
import lombok.Builder;


public class CategoryFlat {

    private String name;

    //Só inicializo espaço na lista de categorias quando crio a categoria
    @Builder
    public CategoryFlat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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
