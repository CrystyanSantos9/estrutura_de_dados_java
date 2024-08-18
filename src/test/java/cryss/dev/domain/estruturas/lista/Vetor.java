package cryss.dev.domain.estruturas.lista;

import cryss.dev.domain.aluno.Aluno;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;


public class Vetor {
    //Declarando e inicializando um array de Aluno com espaco de 100
    private Aluno[] alunos = new Aluno[100];
    private int posicao = alunos.length - 1;

    public void adiciona(Aluno aluno){
        if(Objects.nonNull (aluno)){
            if(alunos.length == 100) {
                alunos[posicao] = aluno;
            }

            if(posicao >= 0){
                alunos[posicao] = aluno;
                diminuiPosicao ();
            }
        }
    }

    private void diminuiPosicao() {
        posicao = posicao -1;
    }

    public void adiciona(int pos, Aluno aluno) {
       if(posicaoIsValid (pos)){
           alunos[pos] = aluno;
       };
    }

    private boolean posicaoIsValid(int pos) {
        if (posicao >= 0 && posicao < 100) {
            return true;
        }
        return false;
    }

    public Aluno pega(int posicao){
        if(alunos[posicao] != null){
            return alunos[posicao];
        }
        return null;
    }

    public void remove(int pos) {
        if (posicaoIsValid (pos)) {
            alunos[pos] = null;
        }
    }

    public boolean contem(Aluno aluno) {
        if(Objects.isNull (aluno)){
            return false;
        }

        return Arrays.stream (alunos).filter (alunoNaLista -> ObjectUtils.isNotEmpty (aluno.getNome ()) && aluno.equals (alunoNaLista))
                .findAny ()
                .stream ()
                .parallel ()
                .collect (Collectors.toList ()).size () == 1;
    }

    public int tamanho(){ return alunos.length; }

    public String toStrig(){
        return Arrays.toString (alunos);
    }

}
