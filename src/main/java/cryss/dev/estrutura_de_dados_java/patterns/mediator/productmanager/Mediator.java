package cryss.dev.estrutura_de_dados_java.patterns.mediator.productmanager;

import cryss.dev.estrutura_de_dados_java.patterns.mediator.productmanager.command.Command;
import cryss.dev.estrutura_de_dados_java.patterns.mediator.productmanager.query.Query;


public interface Mediator {
    void sendCommand(Command command);
    <T> T sendQuery(Query<T> query);
}
