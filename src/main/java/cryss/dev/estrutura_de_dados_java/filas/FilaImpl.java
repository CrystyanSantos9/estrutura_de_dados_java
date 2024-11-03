package cryss.dev.estrutura_de_dados_java.filas;

import java.util.LinkedList;
import java.util.List;

public class FilaImpl <T> implements Fila <T> {

    private List<T> alunoList = new LinkedList<> ();

    @Override
    public void insere(T aluno) {
        this.alunoList.add (aluno);
    }

    @Override
    public T remove() {
        return this.alunoList.remove (0);
    }

    @Override
    public boolean vazia() {
        return alunoList.size () == 0;
    }
}
