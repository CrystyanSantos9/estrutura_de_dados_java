package cryss.dev.domain.aluno;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    @Test
    void equalsWhenValidAlunoReturnTrue(){

        Aluno aluno1 = Aluno
                .builder ()
                .nome ("Fabio")
                .build ();

        Aluno aluno2 = Aluno
                .builder ()
                .build ();


        assertTrue (aluno1.equals (aluno2));

    }
}