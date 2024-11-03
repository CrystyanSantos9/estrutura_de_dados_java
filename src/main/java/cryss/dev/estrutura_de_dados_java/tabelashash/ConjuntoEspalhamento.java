package cryss.dev.estrutura_de_dados_java.tabelashash;

import java.util.List;

public interface ConjuntoEspalhamento {
    public void adiciona(String palavra);

    public void remove(String palavra);

    public boolean contem(String palavra);

    public List<String> pegaTodas();

    public int tamanho();

    public void imprimeTabela();

}
