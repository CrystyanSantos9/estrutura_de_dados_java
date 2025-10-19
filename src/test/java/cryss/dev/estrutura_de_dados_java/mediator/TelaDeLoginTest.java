package cryss.dev.estrutura_de_dados_java.mediator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TelaDeLoginTest {

    //out representa o fluxo de saída padrão do sistema todo
    private final PrintStream standardOut = System.out;
    //um captor
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        //reatribuindo o fluxo de saída padrão
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void verificaSeBotaoDeLoginFoiClicado(){
        //given


        BotaoDeLogin botaoDeLogin = new BotaoDeLogin ("Botao Tela Login");
        TelaDeLogin telaDeLogin = new TelaDeLogin (botaoDeLogin);

        //when
        //then
        botaoDeLogin.cliqueAcionado ();
        Assertions.assertTrue (outputStreamCaptor.toString ().trim ().contains ("Botão de login clicado ==> chamar próxima tela, ou validação"));

    }

}