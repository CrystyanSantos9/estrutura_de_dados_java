package cryss.dev.estrutura_de_dados_java.mediator;

public class TelaDeLogin implements Mediador {

    //Os mediadores concretos devem saber todos os elementos que comporão
    //seu comportamento - itens que serão acionados nele
    private BotaoDeLogin botaoDeLogin;


    public TelaDeLogin(BotaoDeLogin botaoDeLogin) {
        this.botaoDeLogin = botaoDeLogin;
        this.botaoDeLogin.setMediador (this);
    }

    @Override
    public void notificaOutroElement(Elemento elementoAcionado, String eventoAcionado) {
        //toda a lógica de ação/reacao aos elementos gerenciados pelo mediador
        //ficarão na implementação do mediador
        if(elementoAcionado.equals (botaoDeLogin) && eventoAcionado.equals ("cliqueAcionado")){
            System.out.println ("Botão de login clicado ==> chamar próxima tela, ou validação");
        }
    }
}
