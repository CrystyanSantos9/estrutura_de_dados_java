package cryss.dev.domain.estruturas.lista;

import cryss.dev.domain.aluno.Aluno;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Vetor {
    //Declarando e inicializando um array de Aluno com espaco de 100
    private Aluno[] alunos = new Aluno[100];

    //compactando os dados à esquerda
    private int tamanhoLista = 0;

    public void adiciona(Aluno aluno){
        if(Objects.nonNull (aluno)){
            if(tamanhoLista < alunos.length) {
                alunos[tamanhoLista] = aluno;
                tamanhoLista = tamanhoLista +1;
            }
        }
    }


    public void adiciona(int pos, Aluno aluno) {
       if(!posicaoIsValid (pos)){
           throw new IllegalArgumentException ("Posição inválida");
       };

       if(pos <= tamanhoLista){
           alunos[pos] = aluno;
       }

       if(pos == tamanhoLista){
           alunos[pos] = aluno;
           tamanhoLista = tamanhoLista + 1;
       }

       if(pos> tamanhoLista){
           throw new IllegalArgumentException ("Posição inválida. Próximo espaço disponivel: " + tamanhoLista);
       }
    }

    private boolean posicaoIsValid(int pos) {
        return pos >= 0 && pos < 100;
    }

    public Aluno pega(int posicao){
        if(!posicaoIsValid(posicao)){
            throw new IllegalArgumentException ("Posição inválida");
        }
        return alunos[posicao];
    }

    public void remove(int pos) {
        if (posicaoIsValid (pos)) {
            alunos[pos] = null;
        }
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
