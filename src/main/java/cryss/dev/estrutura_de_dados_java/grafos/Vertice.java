package cryss.dev.estrutura_de_dados_java.grafos;

import java.util.Objects;

public record Vertice(String rotulo, int grau) {
    public Vertice {
        if(Objects.isNull (rotulo) || rotulo.isEmpty ()){
            throw new RuntimeException ("Não é permitida a criação de vértices que não contenham rótulos.");
        }

    }

    public Vertice (String rotulo){
        this(rotulo, 0);
    }

    public Vertice addGrau() {
        return new Vertice (this.rotulo, this.grau + 1);
    }
}
