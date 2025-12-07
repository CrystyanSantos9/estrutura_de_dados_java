package cryss.dev.estrutura_de_dados_java.grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo {

    private int qtdMaxVertices;
    private boolean isQtdMaxDefinida;
    private int qtdAtualvertices = 0;
    private Map<String, Integer> rotulosEmIndices = new HashMap<> ();
    private List<Vertice> vertices = new ArrayList<> ();
    private MatrizAdjacencia matrizAdjacencia;

    public Grafo(){
        qtdMaxVertices = 10;
    }

    public Grafo(int qtdVerticesInformada){
        if(qtdVerticesInformada<=0){
            throw new IllegalArgumentException ("A quantidade de vértices deve ser maior ou igual a 1");
        }

        qtdMaxVertices = qtdVerticesInformada;
        isQtdMaxDefinida = true;
    }

    public void adicionarVertice(String rotulo) {
        //0 a 9 = 10 e 10 é o max
        if (qtdAtualvertices <= qtdMaxVertices - 1) {
            Vertice novoVertice = new Vertice (rotulo);
            this.vertices.add (novoVertice);
            this.rotulosEmIndices.put (novoVertice.rotulo (), qtdAtualvertices);
            //um método de ler / modificar / escrever == precisava ser syncronized caso thread
            qtdAtualvertices++;
        } else {
            throw new RuntimeException ("A quantidade de vértices permitida (" + qtdMaxVertices + ") foi excedida.");
        }
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public Vertice getVertice(String rotulo){
        this.existeVerticeOrThrow(rotulo);
        int indice = this.rotulosEmIndices.get (rotulo);
        return this.vertices.get (indice);
    }

    public void conectaVertices(String rotuloDoVerticeInicial, String rotuloDoVerticeFinal){
        //Verifica se ambos os vertices existem
        if(!this.existeVertice (rotuloDoVerticeInicial) ||
        !this.existeVertice (rotuloDoVerticeFinal)){
            throw new RuntimeException ("Ambos os vertices precisam existir para adicionar a aresta.");
        }
        //sem tem vertices, entao pode criar a matris
        criarMatrizAdjacencia();
        int indiceVerticeFinal = this.rotulosEmIndices.get (rotuloDoVerticeInicial);
        int indiceVerticeInicial = this.rotulosEmIndices.get (rotuloDoVerticeFinal);
        this.matrizAdjacencia.adicionaAresta (indiceVerticeInicial, indiceVerticeFinal);
    }

    private void criarMatrizAdjacencia() {
        if(this.matrizAdjacencia == null){
            this.matrizAdjacencia = new MatrizAdjacencia (new ArrayList<> (this.vertices));
        }
    }

    public List<Vertice> getAdjacencias(String vertice){
        this.existeVerticeOrThrow (vertice);
        int indiceVertice = this.rotulosEmIndices.get (vertice);
        return this.matrizAdjacencia.getAdjacencias (indiceVertice);
    }


    private boolean existeVerticeOrThrow(String vertice){
        if(!existeVertice(vertice)){
            throw new IllegalArgumentException ("O vértice informado não existe.");
        }
        return true;
    }

    private boolean existeVertice(String rotuloVertice){
        int indice = this.rotulosEmIndices.get (rotuloVertice);
        return this.vertices.get (indice) != null;
     }

}
