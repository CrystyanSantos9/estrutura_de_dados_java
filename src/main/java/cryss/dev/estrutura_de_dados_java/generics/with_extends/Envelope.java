package cryss.dev.estrutura_de_dados_java.generics.with_extends;

public class Envelope <T extends SuperObject>{
    void showConcreteSubs(T t){
        System.out.println (t.getClass ().getCanonicalName ());
    }
}
