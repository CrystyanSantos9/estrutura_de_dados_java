package cryss.dev.estrutura_de_dados_java.chainofresponsability;

public interface ManipuladorVulgoHandler {
    OrderUser manipula(OrderUser user);

    void setNext(ManipuladorVulgoHandler manipulador);
}
