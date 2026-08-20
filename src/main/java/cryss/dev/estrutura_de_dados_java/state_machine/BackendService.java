package cryss.dev.estrutura_de_dados_java.state_machine;


import org.springframework.stereotype.Component;

@Component
public class BackendService {
    private StateMachine stateMachine;

    public BackendService(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public void iniciProcessamento(){
        stateMachine.processaEventos (Events.INICIA_PROCESSAMENTO);
        System.out.println ("State: " + stateMachine.getEstadoAtual () );
    }


    public void validandoObrigatorios() {
        stateMachine.processaEventos (Events.ENVIA_PARA_INTEGRACAO);
        System.out.println ("State: " + stateMachine.getEstadoAtual () );
    }

    public void enviandoIntegracao() {
//        stateMachine.processaEventos (Events.F);
        System.out.println ("State: " + stateMachine.getEstadoAtual () );
    }

    public void finalizando() {
        System.out.println ("State: " + stateMachine.getEstadoAtual () );
    }
}
