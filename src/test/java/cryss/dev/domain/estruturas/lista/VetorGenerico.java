package cryss.dev.domain.estruturas.lista;

import cryss.dev.domain.aluno.Aluno;
import org.apache.commons.lang3.ObjectUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class VetorGenerico<T extends Aluno> {
    //Declarando e inicializando um array de Aluno com espaco de 100
    private ArrayList<T> alunos = new ArrayList<T> ();

    //compactando os dados à esquerda
    private int tamanhoLista = 0;

//    public void adiciona(Aluno aluno){
//        if(Objects.nonNull (aluno)){
//            if(tamanhoLista < alunos.length) {
//                alunos[tamanhoLista] = aluno;
//                tamanhoLista = tamanhoLista +1;
//            }
//        }
//    }


//    Estoura out of bounds for length
    public void adiciona(T aluno){
        if(Objects.nonNull (aluno)){
                this.alunos.ensureCapacity (this.alunos.size ());
                alunos.add (aluno);
                tamanhoLista = tamanhoLista +1;

        }
    }


    public void adiciona(int pos, T aluno) {
        if (!posicaoIsValid (pos)) {
            throw new IllegalArgumentException ("Posição inválida");
        };

        for (int i = tamanhoLista - 1; i >= pos; i = i - 1) {
            //desloca elementos da posicao informada para à direita
            alunos.add (i+1, alunos.get (i));
        }

        alunos.add (pos, aluno);
        tamanhoLista = tamanhoLista + 1;
    }

    private boolean posicaoIsValid(int pos) {
        return pos >= 0 && pos < this.tamanhoLista;
    }

    public T pega(int posicao){
        if(!posicaoIsValid(posicao)){
            throw new IllegalArgumentException ("Posição inválida");
        }
        return alunos.get (posicao);
    }

    public void remove(int pos) {
        if (!posicaoOcupada (pos)) {
            throw new IllegalStateException ("Posição inválida");
        }

        for(int i = pos; i < this.tamanhoLista - 1; i++){
            this.alunos.remove (i);
            this.alunos.add (i,  this.alunos.get (i+1));
        }

        this.tamanhoLista = tamanhoLista - 1;

    }

    public boolean remove(Aluno object){
       return this.alunos.remove (object);
    }

    public boolean removeAllOccurrences(Collection<? extends Aluno> object){
        return this.alunos.removeAll (object);
    }

    private boolean posicaoOcupada(int posicao){
        return posicao < this.tamanhoLista && posicao >=0;
    }

    public boolean  contem(T  aluno) {

        if (Objects.isNull (aluno) && ObjectUtils.isNotEmpty (aluno.getNome ())) {
            return false;
        }

        return alunos.stream ()
                .filter (alunoNaLista -> aluno.equals (alunoNaLista))
                .collect (Collectors.toList ()).size () == 1;
    }
    public int tamanho(){ return tamanhoLista; }

    public String toString(){
        return alunos.stream ()
                .filter (Objects::nonNull)
                .map (Aluno::toString)
                .collect(Collectors.joining (",", "[", "]"));
    }




}
