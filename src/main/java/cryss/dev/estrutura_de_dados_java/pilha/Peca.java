package cryss.dev.estrutura_de_dados_java.pilha;

import com.fasterxml.jackson.core.JsonProcessingException;
import cryss.dev.estrutura_de_dados_java.utils.JSONSerializer;

public class Peca {
    private String nome;

    private Peca(Builder builder) {
        this.nome = builder.nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static class Builder {
        private String nome;

        public static Builder newInstance(){
            return new Builder ();
        }

        private Builder() {}

        public Builder withName(String nome){
            this.nome = nome;
            return this;
        }

        public Peca build(){
            return new Peca (this);
        }
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
