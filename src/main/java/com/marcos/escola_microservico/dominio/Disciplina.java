package com.marcos.escola_microservico.dominio;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "disciplina")
@Table(name = "disciplina")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private String descricao;
    private String data;
    private int qtdeAlunosMatriculados;
    private int qtdeMaxAlunos;

}
