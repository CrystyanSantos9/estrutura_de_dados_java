package cryss.dev.estrutura_de_dados_java.patterns.mediator.components;

import cryss.dev.estrutura_de_dados_java.patterns.mediator.mediator.Mediator;
import cryss.dev.estrutura_de_dados_java.patterns.mediator.mediator.Note;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddButton extends JButton implements Component {

    private Mediator mediator;

    //Isso aqui é do Jbutton para dar nome ao botão
    public AddButton(){
        super("Add");
    }


    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

//Evento do botão acionado
//Chamando notificador do mediator
    protected void fireActionPerformed(ActionEvent actionEvent){
        mediator.addNewNote (new Note ());
    }

    @Override
    public String getName() {
        return "AddButton";
    }

}
