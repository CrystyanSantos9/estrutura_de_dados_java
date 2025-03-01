package cryss.dev.estrutura_de_dados_java.state.doc_state;

public class Moderation implements DocState {

    private DocContext context;

    public Moderation(DocContext context) {
        this.context = context;
    }

    @Override
    public void publish() {
        if (context.isApprovedByAdmin ()) {
            context.changeState (new Published (context));
        } else {
            context.changeState (new Draft (context));
        }
    }
}
