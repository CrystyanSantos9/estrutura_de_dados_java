package cryss.dev.estrutura_de_dados_java.patterns.mediator.mediator;

import cryss.dev.estrutura_de_dados_java.patterns.mediator.components.Component;

import javax.swing.*;

public interface Mediator {
    void addNewNote(Note note);
    void deleteNote();
    void getInfoFromList(Note note);
    void saveChanges();
    void markNote();
    void clear();
    void sendToFilter(ListModel listModel);
    void setElementsList(ListModel list);
    void registerComponent(Component component);
    void hideElements(boolean flag);
    void createGUI();

}
