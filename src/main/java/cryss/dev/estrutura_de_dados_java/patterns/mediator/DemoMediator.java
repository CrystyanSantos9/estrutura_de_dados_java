package cryss.dev.estrutura_de_dados_java.patterns.mediator;

import cryss.dev.estrutura_de_dados_java.patterns.mediator.components.AddButton;
import cryss.dev.estrutura_de_dados_java.patterns.mediator.components.DeleteButton;
import cryss.dev.estrutura_de_dados_java.patterns.mediator.components.Filter;
import cryss.dev.estrutura_de_dados_java.patterns.mediator.components.List;
import cryss.dev.estrutura_de_dados_java.patterns.mediator.components.SaveButton;
import cryss.dev.estrutura_de_dados_java.patterns.mediator.components.TextBox;
import cryss.dev.estrutura_de_dados_java.patterns.mediator.components.Title;
import cryss.dev.estrutura_de_dados_java.patterns.mediator.mediator.Editor;
import cryss.dev.estrutura_de_dados_java.patterns.mediator.mediator.Mediator;

import javax.swing.*;

public class DemoMediator {
    public static void main(String[] args) {
        Mediator mediator = new Editor ();

        mediator.registerComponent (new Title ());
        mediator.registerComponent(new TextBox ());
        mediator.registerComponent(new AddButton ());
        mediator.registerComponent(new DeleteButton ());
        mediator.registerComponent(new SaveButton ());
        mediator.registerComponent(new List (new DefaultListModel ()));
        mediator.registerComponent(new Filter ());

        mediator.createGUI();
    }
}
