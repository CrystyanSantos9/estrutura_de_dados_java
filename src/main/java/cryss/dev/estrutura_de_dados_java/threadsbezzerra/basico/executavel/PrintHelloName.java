package cryss.dev.estrutura_de_dados_java.threadsbezzerra.basico.executavel;

public class PrintHelloName implements Runnable {

    private String name;

    public PrintHelloName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try{
            System.out.println ("Hello name: " + this.name + ". executed in thread: " + Thread.currentThread ().getName ());
            Thread.sleep (60000);
        }  catch (InterruptedException e) {
            System.out.println ("method interrupetd" + this.name);
            e.printStackTrace ();
        }
    }
}
