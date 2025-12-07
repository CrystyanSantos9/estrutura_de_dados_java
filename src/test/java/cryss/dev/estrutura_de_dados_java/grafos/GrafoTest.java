package cryss.dev.estrutura_de_dados_java.grafos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GrafoTest {

private Grafo grafo;

    @BeforeEach
    void seutup(){
        grafo = new Grafo ();

        grafo.adicionarVertice("RJ");
        grafo.adicionarVertice("SP");
        grafo.adicionarVertice("BH");
        grafo.adicionarVertice("PT");
        grafo.adicionarVertice("OS");
        grafo.adicionarVertice("SV");
        grafo.adicionarVertice("CR");
        grafo.adicionarVertice("PA");
    }

    @Test
    void adicionarVertice() {
        System.out.println("O grafo G possui os seguintes vértices:");
        System.out.println();
        for(Vertice vertice : grafo.getVertices()) {
            System.out.println("- Vértice " + vertice.rotulo ());
        }
    }

    @Test
    void testaVertice() {

        Integer[][] matriz;
        List<String> vertices = new ArrayList<> ();
        vertices.add ("A");
        vertices.add ("B");
        vertices.add ("C");
        vertices.add ("D");

        //Inicializando matriz
        matriz = inicializaMatriz(vertices.size ());

//        preenche matriz com zeros
        for(var i = 0; i < matriz.length; i++){
            for (var j = 0; j < matriz[i].length; j++){
                System.out.println ("I=" + i + "J=" + j);
                matriz[i][j] = 0;
            }
        }

        matriz[0][1] = 1;
        matriz[1][1] = 1;

        //exibindo matriz
        for(Integer[] linha: matriz){
            for(Integer elemento: linha){
                System.out.println ("Elemento " + elemento);
            }
        }

    }

    private Integer[][] inicializaMatriz(int qtdVertices) {
        return new Integer[qtdVertices][qtdVertices];
    }
}