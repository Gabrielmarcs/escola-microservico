package com.marcos.escola_microservico.repositorio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.marcos.escola_microservico.dominio.Disciplina;

import jakarta.annotation.Nonnull;

public interface DisciplinaRepositorio extends JpaRepository<Disciplina, String>{
    @Query(value = "SELECT * FROM disciplina d WHERE parsedatetime(d.data, 'dd/MM/yyyy') > :dataAtual", nativeQuery = true)
    List<Disciplina> disciplinasFuturas(@Param("dataAtual") LocalDateTime dataAtual);

    @Nonnull
    Optional<Disciplina> findById(@Nonnull String id);
}
