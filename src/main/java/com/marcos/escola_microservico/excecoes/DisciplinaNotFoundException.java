package com.marcos.escola_microservico.excecoes;

public class DisciplinaNotFoundException extends RuntimeException{
    public DisciplinaNotFoundException(){
        super("Disciplina não encontrada");
    }

    public DisciplinaNotFoundException(String mensagem){
        super(mensagem);
    }
}
