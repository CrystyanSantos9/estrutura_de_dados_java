package cryss.dev.reflection.domain;

public class Dog implements Animal{
    @Override
    public void makeASound() {
        System.out.println ("Bark");
    }
}
