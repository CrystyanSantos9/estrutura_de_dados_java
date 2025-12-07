package cryss.dev.estrutura_de_dados_java.grafos;

import java.util.ArrayList;
import java.util.List;

public class MatrizAdjacencia {
    private int[][] matriz;
    private List<Vertice> vertices;
    private int qtdVertices;

    public MatrizAdjacencia(List<Vertice> vertices){
        this.vertices = vertices;
        this.qtdVertices = vertices.size ();
        matriz = new int[qtdVertices][qtdVertices];
        inicializarMatriz();
    }

    private void inicializarMatriz() {
        //I representa as colunas
        for (int i = 0; i < matriz.length; i++) {
            //j representando as linas da coluna atual
            for (int j = 0; j < matriz[i].length; j++) {
                //para cada linha J da coluna I faça
                matriz[i][j] = 0;
            }
        }
    }

    public void adicionaAresta(int indiceVerticeInicial, int indiceVerticeFinal){
        Vertice verticeInicialRecuperado = vertices.get (indiceVerticeInicial);
        Vertice verticeFinalRecuperado = vertices.get (indiceVerticeFinal);

        //Se a conexão é um ciclo, ou seja a aresta sai e volta para o mesmo vértice
        if(indiceVerticeInicial == indiceVerticeFinal){
            matriz[indiceVerticeInicial][indiceVerticeInicial] = 1 ;
            vertices.set (indiceVerticeInicial, verticeInicialRecuperado.addGrau());
        } else {
            matriz[indiceVerticeInicial][indiceVerticeFinal] = 1;
            vertices.set (indiceVerticeInicial, verticeInicialRecuperado.addGrau ());

            matriz[indiceVerticeFinal][indiceVerticeInicial] = 1;
            vertices.set (indiceVerticeInicial, verticeFinalRecuperado.addGrau ());

        }
    }

    public List<Vertice> getAdjacencias(int indiceVertice){
        int linha = indiceVertice;
        List<Vertice> adjacencias = new ArrayList<> ();
        for(int j = 0; j<vertices.size (); j++){
            if(matriz[linha][j]==1){
                Vertice vertice = vertices.get (j);
                adjacencias.add (vertice);
            }
        }
        return adjacencias;
    }
}
