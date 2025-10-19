package cryss.dev.estrutura_de_dados_java.mediator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class BotaoDeLogin extends Elemento {

    public BotaoDeLogin(String name) {
        super (name);
    }

    public void cliqueAcionado(){
        // o mediador vai passar o próprio objeto para ser usado no
        System.out.println ("Botão acionado");
        mediador.notificaOutroElement (this, "cliqueAcionado");
    }

}
