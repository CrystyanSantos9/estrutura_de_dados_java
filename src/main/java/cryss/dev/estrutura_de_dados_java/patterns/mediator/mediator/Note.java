package cryss.dev.estrutura_de_dados_java.patterns.mediator.mediator;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Note {
    private String name;
    private String text;

    public Note() {
        this.name = "New note";
    }


}
