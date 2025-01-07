package cryss.dev.estrutura_de_dados_java.liskov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteDaListaDeCategoriasTest {
    @Test
    void testaIteracaoNaListaDeCategorias(){
        //Mostrando um pouco de encapsulamento e métodos tímidos
        //escondendo os detalhes de implementação com iterator e iterable

        Category category1 = new Category.Builder ().withName ("Cosméticos").build ();
        Category category2 = new Category.Builder ().withName ("Batons").build ();

        ListaIteravelDeCategorias listaIteravelDeCategorias = new ListaIteravelDeCategorias ();
        listaIteravelDeCategorias.addCategory (category1);
        listaIteravelDeCategorias.addCategory (category2);

        ClienteDaListaDeCategorias clienteDaListaDeCategorias = new ClienteDaListaDeCategorias ();

        clienteDaListaDeCategorias.exibeCategorias (listaIteravelDeCategorias);

    }
}