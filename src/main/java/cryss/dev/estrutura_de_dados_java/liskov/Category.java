package cryss.dev.estrutura_de_dados_java.liskov;

import lombok.Data;

@Data
public class Category {
    private final String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static class Builder{
        private String name;
        public Builder withName(String name){
             this.name = name;
            return this;
        }
       public  Category build(){
            return new Category (this.name);
        }
    }
}
