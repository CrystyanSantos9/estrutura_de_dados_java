package cryss.dev.estrutura_de_dados_java.java_efetivo.tipo_parametrizado.tipo_parametrizado_variante;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

/*
*  Página 220 cap 31
* */
public class UsandoTipoParametrizadoVariante {
    public static void main(String[] args) {
        StackParametrizadaVariante numberStack = new StackParametrizadaVariante ();
        //Src é um argumento do tipo Produtor - Supplier
        Iterable<Integer> integers = List.of (1, 2,3);

//        Argumento produto use <? extends E>
//        Uso de argumentos para produzir algo para consumo posterior use extends
        numberStack.pushAll (integers);
        List<Integer> ArgumentoConsumidor = new ArrayList<> ();

//        Argumento consumidor use <? super E>
//        o tipo que vai ser consumido pode ser um superTipo de Integer
        numberStack.popAll (ArgumentoConsumidor);

//        Use o Mnemônico PECS
        /*
        *  Produtor extends = tipo é um subtipo de E
        *  Consumidor super = tipo é um Supertipo de E
        *
        * */
        System.out.println (ArgumentoConsumidor);

        //Varias tipos de listas produtoras
        Set<Integer> integers1 = Set.of (1, 3, 4);
        Set<Double> dobules = Set.of (2.0, 4.0, 4.1);
        Set<BigDecimal> bigDecimals = Set.of (BigDecimal.TEN);

//        Ele sabe receber qualquer tipo de Number agora sem reclmar
        numberStack.union(integers1, bigDecimals);
        System.out.println (numberStack.max (dobules));
    }
}

class StackParametrizadaVariante {

    Stack stack = new Stack ();

/*
 <? extends E> == chamdo de wildcard limitado

 o tipo de pushAll deve ser um <? extends E>, que quer dizer,

    - que o tipo de argumento é algum subtipo de E

    o método agora é typeSafe

* */


    public <E> void pushAll(Iterable<? extends E> src){
        for(E e: src){
            stack.push (e);
        }
    }

/*
* @param dst --> Nova collecao de destino
*
*@desc --> popAll remove cada elemento da pilha e adiciona a uma dada colecao
*
* */

    //<editor-fold desc="colecao de E está errada.">
//    public <E> void popAll(Collection<E> dst){
//        while (!stack.isEmpty ()){
//            dst.add (stack.pop ());
//        }
//    }
    //</editor-fold>

    /*
    *  Se o argumento passado é consumidor
    *  Ou seja, uma lista que vai receber um elemento de um tipo
    *  o certo é esse argumento parametrizado ser uma coleção do Supertipo do elemento consumido
    *
    *  Collection<? super E> elementoConsumidor
    *
    *
    * */

    public <E> void popAll(Collection<? super E> listaConsumidora){
        while (!stack.isEmpty ()){
            listaConsumidora.add (pop ());
        }
    }

    //precisei fazer isso para realizar o cast correto
    public <E> E pop(){
        return (E) this.stack.pop ();
    }

//    S1 e S2 são produtores de E, serão armazenados para uso posterior
    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2){
        Set<E> union = new HashSet<> (s1);
        /*
        *  Para adicionar Conjuntos, utilize addAll()
        *  Para elementos add()
        * */
        union.addAll (s2);
        return union;

    }

    /*
    *  Retorna o maior número na lista
    * */

//    Vai retornar T, sendo T um subtipo de Comparable, mas o Comparable, por ser consumidor,
//    vai receber T ou um supertipo de T para comparar, para consumir esse valor
//    Comparator é sempre consumidor logo use o wildcard limitado <? super T>

    public static <T extends Comparable<? super T>> T max(Collection<? extends T> list){
        if(list.isEmpty ()){
            throw new IllegalArgumentException ("Empty list");
        }

        T result = null;
        for(T e: list) {
//            se é o primeiro elemento a ser comparado result = null, result então = primeiro elemento comparado
//            se o result já tiver elemento e ele for menor que o próximo elemento, entao elemento é o
//            result vai assumindo sempre o maior valor
            if (result == null || e.compareTo (result) > 0) {
                result = Objects.requireNonNull (e);
            }
        }

            return result;
    }
}