package cryss.dev.estrutura_de_dados_java.java_efetivo.tipo_parametrizado.dualidade_tipos_parametrizados;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DualidadeParametrizados {
    public static void main(String[] args) {

//        Para o swapp ocorrer tem que ser uma lista modificavel
        List<Integer> integers = Arrays.asList (1,2,3);

//        Veja que na api publica ( metodo ) o tipo pode ser ? ilitado
//        E internamente o swapp cuida de <E> informar que o que é produzido na lista é do tipo E, e o que é consumido da lista também é E
        Troca.swapIlimitado (integers, 1, 0);

        System.out.println (integers);

    }
}

class Troca {

private static List changed = null;

    public static List getChanged() {
        return changed;
    }

    //    lista com parametro de tipo limitado
    public static <E> void swap(List<E> list,  int i, int j){
        //faz algo
    }


//    lista é um parametro de tipo ilimitado ? = wildcard
    public static void swapIlimitado(List<?> list, int i, int j){

        swapHelperCapituraOTipo(list, i, j);

    }

/*
*
* Usamos o método auxiliar helper, para recuperarmos o tipo de List<?>
  a operacao de inserir nao funciona para list<?>
  * logo é importante o helper para determinar o tipo que será inserido na list
*
* */
    private static <E> void swapHelperCapituraOTipo(List<E> list,  int i, int j){
//        list.set (i, list.set (j, list.get (i)));
//        Implementacao do java, ou a forma acima.
        Collections.swap (list, i, j);
    }
}
