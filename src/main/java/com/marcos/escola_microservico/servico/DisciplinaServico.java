package com.marcos.escola_microservico.servico;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import com.marcos.escola_microservico.dominio.Disciplina;
import com.marcos.escola_microservico.dominio.Inscricao;
import com.marcos.escola_microservico.excecoes.DisciplinaNotFoundException;
import com.marcos.escola_microservico.modelo.DisciplinaModelo;
import com.marcos.escola_microservico.modelo.EmailModelo;
import com.marcos.escola_microservico.repositorio.DisciplinaRepositorio;
import com.marcos.escola_microservico.repositorio.InscricaoRepositorio;

@Service
public class DisciplinaServico {
    @Autowired
    private DisciplinaRepositorio disciplinaRepositorio;

    @Autowired
    private InscricaoRepositorio inscricaoRepositorio;

    @Autowired
    private EmailServicoCliente emailServicoCliente;

    public List<Disciplina> getDisciplinas() {
        return disciplinaRepositorio.findAll();
    }

    public List<Disciplina> getProximasDisciplinas(){
        return disciplinaRepositorio.disciplinasFuturas(LocalDateTime.now());
    }

    public Disciplina criarDisciplina(DisciplinaModelo disciplinaModelo) {
        Disciplina disciplina = new Disciplina(disciplinaModelo);
        return disciplinaRepositorio.save(disciplina);
    }

    public void matricularAluno(String idDisciplina, String nomeAluno, String emailAluno){
        Disciplina disciplina = disciplinaRepositorio.findById(idDisciplina).orElseThrow(DisciplinaNotFoundException::new);

        if (disciplina.getQtdeAlunosMatriculados() < disciplina.getQtdeMaxAlunos()) {
            Inscricao inscricao = new Inscricao(disciplina, nomeAluno, emailAluno);
            inscricaoRepositorio.save(inscricao);

            disciplina.setQtdeAlunosMatriculados(disciplina.getQtdeAlunosMatriculados() + 1);
         
            emailServicoCliente.enviarEmail(emailAluno, "Inscrição realizada", "Você foi inscrito na disciplina " + disciplina.getNome() + " com sucesso! \n :)");
        } else {
            emailServicoCliente.enviarEmail(emailAluno, "Inscrição não realizada", "A disciplina " + disciplina.getNome() + " está lotada  \n :( ");
        }
    }
}
