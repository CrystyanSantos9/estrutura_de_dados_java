package cryss.dev.estrutura_de_dados_java.pilha;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CriptografaFraseTest {

    @Test
    void impremeOInverso(){
        String frase = "Poa poa";

        String fraseCriptografada = CriptografaFrase.criptografa (frase);

//        assertEquals ("aop aoP", fraseCriptografada);


        String frase2 = "Uma linda jóia amarela na casa";
        String fraseCriptografada2 = CriptografaFrase.criptografa (frase2);

        System.out.println (fraseCriptografada2);


    }
}