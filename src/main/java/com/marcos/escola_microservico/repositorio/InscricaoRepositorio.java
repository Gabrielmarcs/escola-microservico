package com.marcos.escola_microservico.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcos.escola_microservico.dominio.Inscricao;

public interface InscricaoRepositorio extends JpaRepository<Inscricao, Long> {
    
}
