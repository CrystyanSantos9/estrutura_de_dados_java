package cryss.dev.estrutura_de_dados_java.patterns.mediator.components;

import cryss.dev.estrutura_de_dados_java.patterns.mediator.mediator.Mediator;
import cryss.dev.estrutura_de_dados_java.patterns.mediator.mediator.Note;

import javax.swing.*;
import java.util.ArrayList;

public class Filter extends JTextField implements Component {

    private Mediator mediator;
    private ListModel listModel;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void setList(ListModel listModel) {
        this.listModel = listModel;
    }

    private void searchElements(String s){
        if(listModel == null){
            return;
        }

        if(s.equals ("")){
            mediator.setElementsList (listModel);
            return;
        }

        ArrayList<Note> notes = new ArrayList<> ();
        for (int i = 0; i < listModel.getSize(); i++) {
            notes.add ((Note) listModel.getElementAt (i));
        }
        DefaultListModel<Note> listModel = new DefaultListModel<>();
        //se alguma nota contém a string informada
        //coloque ela na lista que será apresentada ao usuário
        for (Note note : notes) {
            if (note.getName().contains(s)) {
                listModel.addElement(note);
            }
        }
        //notifca o mediator
        mediator.setElementsList (listModel);

    }

    @Override
    public String getName() {
        return "Filter";
    }


}
