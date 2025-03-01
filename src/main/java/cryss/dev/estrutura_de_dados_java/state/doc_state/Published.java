package cryss.dev.estrutura_de_dados_java.state.doc_state;

public class Published implements DocState {

    private DocContext context;


    public Published(DocContext context) {
        this.context = context;
    }

    @Override
    public void publish() {
        System.out.println ("DOC from user: " + context.getUsarId() +" is published.");
    }
}
