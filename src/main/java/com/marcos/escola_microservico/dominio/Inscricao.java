package com.marcos.escola_microservico.dominio;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "inscricao")
@Table(name = "inscricao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Inscricao {
    @Id
    GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    private Disciplina disciplina;

    private String emailAluno;
    private String nomeAluno;
}
