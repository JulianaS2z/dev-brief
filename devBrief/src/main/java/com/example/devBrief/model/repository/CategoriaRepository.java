package com.example.devBrief.model.repository;

import com.example.devBrief.model.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
    Optional<CategoriaEntity> findByNome(String nome);
}

