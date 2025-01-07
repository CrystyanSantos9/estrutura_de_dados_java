package cryss.dev.estrutura_de_dados_java.liskov;

public class ClienteDaListaDeCategorias {
    public void exibeCategorias(ListaIteravelDeCategorias listaIteravelDeCategorias){

        //veja que como os dados são recuperados, não são exibidos, os detalhes estão internos à lista.
        for(Category category: listaIteravelDeCategorias){
            System.out.printf ("Categoria da lista" + category);
        }
    }
}
