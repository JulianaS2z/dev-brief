package com.example.devBrief.model.repository;

import com.example.devBrief.model.entity.FornecedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FornecedorRepository extends JpaRepository<FornecedorEntity, Long> {
    Optional<FornecedorEntity> findByEmail(String email);
}