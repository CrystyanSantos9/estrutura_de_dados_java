package cryss.dev.estrutura_de_dados_java.tabelashash;

import java.util.List;

public interface ConjuntoEspalhamento <T> {
    public void adiciona(T palavra);

    public void remove(T palavra);

    public boolean contem(T palavra);

    public List<T> pegaTodas();

    public int tamanho();

    public void imprimeTabela();

}
