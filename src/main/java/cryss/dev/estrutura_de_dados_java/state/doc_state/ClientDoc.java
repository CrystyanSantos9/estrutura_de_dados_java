package cryss.dev.estrutura_de_dados_java.state.doc_state;

public class ClientDoc {
    public static void main(String[] args) {
        DocUser user1 = new DocUser ("1","ADMIN");
        DocContext doc1 = new DocContext (user1);
        System.out.println ("Estado atual: " + doc1.getCurrentState ());
        doc1.publish ();

        //DRAFT Publicado pelo usuário = Moderation
        System.out.println ("Estado atual: " + doc1.getCurrentState ());

        //Moderation Publicado sem aproved by admin = Draft
        doc1.publish ();
        System.out.println ("Estado atual: " + doc1.getCurrentState ());
        //aprovando byAdmin
        doc1.approveByAdmin ();
        //Pasando novamente para moderation
        doc1.publish ();
        System.out.println ("Estado atual: " + doc1.getCurrentState ());
        //publicando final
        doc1.publish ();
        System.out.println ("Estado atual: " + doc1.getCurrentState ());

    }
}
