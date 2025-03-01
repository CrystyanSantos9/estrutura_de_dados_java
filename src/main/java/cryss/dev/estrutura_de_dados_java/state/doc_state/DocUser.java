package cryss.dev.estrutura_de_dados_java.state.doc_state;

import lombok.Getter;
import lombok.Setter;

@Getter
public class DocUser {

    private final String id;

    @Setter
    private String role;

    public DocUser(String id, String role) {
        this.id = id;
        this.role = role;
    }

}
