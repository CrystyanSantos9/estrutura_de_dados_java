package cryss.dev.estrutura_de_dados_java.pilha;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PilhaTestDriver {
    public static void main(String[] args) {
        List caminhoCerto = new ArrayList<> ();
        Pilha<String> caminhoRegistrado = new Pilha<> ();
        caminhoCerto.add ("1,2");
        caminhoCerto.add ("1,5");
        caminhoCerto.add ("1,7");
        caminhoCerto.add ("1,9");

        int posicaoCorreta = 0;


        boolean fim = false;

        Scanner entrada = new Scanner (System.in);

        while (!fim){
            System.out.println ("Digite a posicação x,y para andar: ");
            String escolha = entrada.nextLine ();
            if(caminhoCerto.indexOf (escolha) != -1 && caminhoCerto.indexOf (escolha) == posicaoCorreta){
                caminhoRegistrado.inserenotopo (escolha);
                caminhoCerto.remove (caminhoCerto.indexOf (escolha));
                if(caminhoCerto.isEmpty ()){
                    fim = true;
                }
            }else{
                if(!caminhoRegistrado.Isvazia ()) {
                    System.out.println (String.format ("Caminho %s está errado.", escolha));
                    var ultimoCaminhoRegistradoCerto =  caminhoRegistrado.removedotop ();
                    System.out.println (String.format ("Voltar posição anterior? pos=%s", ultimoCaminhoRegistradoCerto ));
                    caminhoCerto.add ( posicaoCorreta, ultimoCaminhoRegistradoCerto);
                }else{
                    System.out.println (String.format ("Caminho %s está errado.", escolha));
                }
                continue;
            }
        }
    }
}
