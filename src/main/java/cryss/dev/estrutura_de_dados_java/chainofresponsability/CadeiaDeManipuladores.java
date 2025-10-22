package cryss.dev.estrutura_de_dados_java.chainofresponsability;

//aqui eu crio a estrutura que cria a cadeia
public abstract class CadeiaDeManipuladores implements ManipuladorVulgoHandler{

    protected ManipuladorVulgoHandler proximoManipulador;

    //Preciso que seja abstrato
    @Override
    public abstract OrderUser manipula(OrderUser user);

    @Override
    public void setNext(ManipuladorVulgoHandler manipulador) {
        this.proximoManipulador = manipulador;
    }
}
