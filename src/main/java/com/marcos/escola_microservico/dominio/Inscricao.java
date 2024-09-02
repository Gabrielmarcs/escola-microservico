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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Disciplina disciplina;

    private String nomeAluno;
    private String emailAluno;
}
