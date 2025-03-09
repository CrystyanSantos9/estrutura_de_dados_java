package cryss.dev.estrutura_de_dados_java.java_efetivo.tipo_parametrizado.tipo_parametrizado_variante;

import java.util.List;
import java.util.Stack;

public class UsandoTipoParametrizadoInvariante {
    //<editor-fold desc="wild card deficiente - tipos parametrizados são invariantes">
    public static void main(String[] args) {
        StackParametrizadaInvariante numberStack = new StackParametrizadaInvariante ();
        Iterable<Integer> integers = List.of (1,2,3);
//        assinatura do pushAll --> pushal(Iterable<E> src)
        //pushAll recebe um parâmetro tipo parametrizado, por padrao ele é Invariante
        //ou seja, começa integer, e todas as operação serão com integer, src é um tipo de argumento produto
        numberStack.pushAll (integers);

        //de acordo com o autor, no java 7 --> isso retornaria o erro: Incompatible types; Iterable cannot be converted to Iterable<Number>
        //no método pushAll pq Stack por default era <Number> e tipo parametrizado é invariante
    }
    //</editor-fold>
}

class StackParametrizadaInvariante{
    final Stack numberStack = new Stack ();
    public <E> void pushAll(Iterable<E> src){
        for(E e: src){
            numberStack.push (e);
        }
    }
}
