package cryss.dev.domain.estruturas.lista;

import cryss.dev.domain.aluno.Aluno;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class VetorComAdicionarLento {
    //Declarando e inicializando um array de Aluno com espaco de 100
    private Aluno[] alunos = new Aluno[100000];

    //compactando os dados à esquerda
    private int tamanhoLista = 0;

    public void adiciona(Aluno aluno){
        if(Objects.nonNull (aluno)){
           for(int i=0; i<this.alunos.length; i++){
               if(this.alunos[i]==null){
                   this.alunos[i] = aluno;
                   break;
               }
           }
        }
    }


    public void adiciona(int pos, Aluno aluno) {
        if (!posicaoIsValid (pos)) {
            throw new IllegalArgumentException ("Posição inválida");
        };

        for (int i = tamanhoLista - 1; i >= pos; i = i - 1) {
            //desloca elementos da posicao informada para à direita
            alunos[i + 1] = alunos[i];
        }

        alunos[pos] = aluno;
        tamanhoLista = tamanhoLista + 1;
    }

    private boolean posicaoIsValid(int pos) {
        return pos >= 0 && pos < this.tamanhoLista;
    }

    public Aluno pega(int posicao){
        if(!posicaoIsValid(posicao)){
            throw new IllegalArgumentException ("Posição inválida");
        }
        return alunos[posicao];
    }

    public void remove(int pos) {
        if (!posicaoOcupada (pos)) {
            throw new IllegalStateException ("Posição inválida");
        }

        for(int i = pos; i < this.tamanhoLista - 1; i++){
            this.alunos[i] = null;
            this.alunos[i] = this.alunos[i+1];
        }

        this.tamanhoLista = tamanhoLista - 1;

    }

    private boolean posicaoOcupada(int posicao){
        return posicao < this.tamanhoLista && posicao >=0;
    }

    public boolean contem(Aluno aluno) {

        if (Objects.isNull (aluno) && ObjectUtils.isNotEmpty (aluno.getNome ())) {
            return false;
        }

        return Arrays.stream (alunos)
                .filter (alunoNaLista -> aluno.equals (alunoNaLista))
                .collect (Collectors.toList ()).size () == 1;
    }
    public int tamanho(){ return tamanhoLista; }

    public String toString(){
        return Stream.of (alunos)
                .filter (Objects::nonNull)
                .map (Aluno::toString)
                .collect(Collectors.joining (",", "[", "]"));
    }

}
