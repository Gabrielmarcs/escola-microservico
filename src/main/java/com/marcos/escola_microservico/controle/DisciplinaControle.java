package com.marcos.escola_microservico.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcos.escola_microservico.dominio.Disciplina;
import com.marcos.escola_microservico.modelo.DisciplinaModelo;
import com.marcos.escola_microservico.modelo.InscricaoModelo;
import com.marcos.escola_microservico.servico.DisciplinaServico;

import java.util.List;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaControle {
    
    @Autowired
    private DisciplinaServico disciplinaServico;

    @GetMapping
    public List<Disciplina> getDisciplinas(){
        return disciplinaServico.getDisciplinas();
    }

    @GetMapping("/proximas")
    public List<Disciplina> getProximasDisciplinas(){
        return disciplinaServico.getProximasDisciplinas();
    }

    @PostMapping
    public Disciplina criarDisciplina(@RequestBody DisciplinaModelo disciplinaModelo){
        return disciplinaServico.criarDisciplina(disciplinaModelo);
    }

    @PostMapping("/{disciplinaId}/matricular")
    public void matricularAluno(@PathVariable String disciplinaId, @RequestBody InscricaoModelo inscricao){
        disciplinaServico.matricularAluno(disciplinaId, inscricao.nomeAluno(), inscricao.emailAluno());
    }

}
