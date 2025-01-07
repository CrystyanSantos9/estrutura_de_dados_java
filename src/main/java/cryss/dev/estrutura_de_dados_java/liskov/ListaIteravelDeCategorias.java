package cryss.dev.estrutura_de_dados_java.liskov;


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ListaIteravelDeCategorias implements Iterable<Category> {

    private List<Category> categorias;

    public ListaIteravelDeCategorias() {
        this.categorias = new ArrayList<> ();
    }

    public void addCategory(Category category){
        if(Objects.nonNull (category)){
            categorias.add (category);
        }
    }


    @NotNull
    @Override
    public Iterator<Category> iterator() {

        Iterator <Category> iterator = categorias.iterator ();

        return new Iterator<Category> () {
            @Override
            public boolean hasNext() {
                return iterator.hasNext ();
            }

            @Override
            public Category next() {
                Category entry = iterator.next ();
                return entry;
            }
        };
    }
}
