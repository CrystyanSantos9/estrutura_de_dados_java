package cryss.dev.estrutura_de_dados_java.state_machine;

import java.util.EnumMap;
import java.util.Map;

public class StateMachine {
    private State estadoAtual;
    private Map<State, Map<Events, State>> transicoes;

    public StateMachine() {
        this.estadoAtual = State.INICIADO;
        this.transicoes = new EnumMap<> (State.class);
        iniciaTransicao();
    }

    private void iniciaTransicao() {
       //poe a chave do estado, e inicia o map de relação de evento estado
        transicoes.put (State.INICIADO, new EnumMap<> (Events.class));
       //recupera e salva informação na relação da chava
        transicoes.get (State.INICIADO).put (Events.INICIA_PROCESSAMENTO, State.PROCESSANDO_OBRIGATORIOS);

        transicoes.put (State.PROCESSANDO_OBRIGATORIOS, new EnumMap<> (Events.class));
        transicoes.get (State.PROCESSANDO_OBRIGATORIOS).put (Events.ENVIA_PARA_INTEGRACAO, State.ENVIANDO_INTEGRACAO);

        transicoes.put (State.FINALIZADO, new EnumMap<> (Events.class));
        transicoes.put (State.FALHA, new EnumMap<> (Events.class));

    }

    public State getEstadoAtual(){
        return this.estadoAtual;
    }

    public void processaEventos(Events event){
        Map<Events, State> transicaoDeEstado = transicoes.get (estadoAtual);

        // pega o estado inicial, verifica os eventos para transitar o estado atual para ele
        if(transicaoDeEstado != null && transicaoDeEstado.containsKey (event)){
            this.estadoAtual = transicaoDeEstado.get (event);
        }else {
            throw new IllegalArgumentException ("Invalid event: " + event + " for correntState: " + estadoAtual);
        }
    }

    

}
