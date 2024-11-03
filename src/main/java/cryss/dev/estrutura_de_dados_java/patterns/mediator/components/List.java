package cryss.dev.estrutura_de_dados_java.patterns.mediator.components;

import cryss.dev.estrutura_de_dados_java.patterns.mediator.mediator.Mediator;
import cryss.dev.estrutura_de_dados_java.patterns.mediator.mediator.Note;

import javax.swing.*;

@SuppressWarnings("unchecked")
public class List extends JList implements Component {
    private final DefaultListModel LIST_MODEL;
    private Mediator mediator;

    public List(DefaultListModel listModel) {
        super (listModel);
        this.LIST_MODEL = listModel;
        setModel (listModel);
        this.setLayoutOrientation (JList.VERTICAL);
        Thread thread = new Thread (new Hide (this));
        thread.start ();
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void addElement(Note note) {
        LIST_MODEL.addElement (note);
        int index = LIST_MODEL.size () - 1;
        setSelectedIndex (index);
        ensureIndexIsVisible (index);
        //para enviar para o filtro que imprime na tela
        mediator.sendToFilter (LIST_MODEL);
    }

    public void deleteElement() {
        //quando adicionamos, salvamos a posicao da nota ( SUPER )
        int index = this.getSelectedIndex ();
        try {
            LIST_MODEL.remove (index);
            //notifica o mediator para informar as outras classes
            mediator.sendToFilter (LIST_MODEL);
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
    }

    public Note getCurrentElement() {
        return (Note) getSelectedValue ();
    }

    @Override
    public String getName() {
        return "List";
    }

    //para esconder os elementos na tela
    private class Hide implements Runnable {
        private List list;

        Hide(List list) {
            this.list = list;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep (300);
                } catch (InterruptedException ex) {
                    ex.printStackTrace ();
                }
                if (list.isSelectionEmpty ()) {
                    mediator.hideElements (true);
                } else {
                    mediator.hideElements (false);
                }
            }
        }
    }
}



