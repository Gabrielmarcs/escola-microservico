package com.marcos.escola_microservico.repositorio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.marcos.escola_microservico.dominio.Disciplina;

public class DisciplinaRepositorio extends JpaRepository<Disciplina, long>{
    @Query(value = "SELECT * FROM disciplina d WHERE parsetime(e.data, 'dd/MM/yyyy') > currentDate", nativeQuery = true)
    List<Disciplina> encontrarDisciplinas(@Param("currentDate") LocalDateTime currentDate);

    @NonNull
    Optional<Disciplina> buscarPorId(@NonNull long id);
}
