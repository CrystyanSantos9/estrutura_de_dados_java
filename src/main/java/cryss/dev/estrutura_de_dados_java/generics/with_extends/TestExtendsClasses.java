package cryss.dev.estrutura_de_dados_java.generics.with_extends;

public class TestExtendsClasses {
    public static void main(String[] args) {
        ConcreteSubObject concreteSubObject = new ConcreteSubObject ();

        Envelope envelope = new Envelope ();
        OtherClass otherClass = new OtherClass ("charles");

        envelope.showConcreteSubs (concreteSubObject);
//        envelope.showConcreteSubs (otherClass);
    }
}

record OtherClass(String name){}
