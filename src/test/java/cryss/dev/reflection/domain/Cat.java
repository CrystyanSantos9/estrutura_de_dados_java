package cryss.dev.reflection.domain;

public class Cat implements Animal{
    @Override
    public void makeASound() {
        System.out.println ("Meow...meow");
    }
}
