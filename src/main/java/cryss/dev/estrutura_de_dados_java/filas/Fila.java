package cryss.dev.estrutura_de_dados_java.filas;

public interface Fila<T> {
    void insere(T aluno);

    T remove();

    boolean vazia();
}
