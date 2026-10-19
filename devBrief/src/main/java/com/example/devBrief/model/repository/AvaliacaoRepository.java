package com.example.devBrief.model.repository;

import com.example.devBrief.model.entity.AvaliacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository<AvaliacaoEntity, Long> {
    List<AvaliacaoEntity> findByProdutoId(Long produtoId);

    List<AvaliacaoEntity> findByClienteId(Long clienteId);
}
