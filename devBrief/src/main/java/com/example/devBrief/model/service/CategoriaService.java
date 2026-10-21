package com.example.devBrief.model.service;

import com.example.devBrief.model.dto.categoria.CategoriaRequest;
import com.example.devBrief.model.dto.categoria.CategoriaResponse;
import com.example.devBrief.model.entity.CategoriaEntity;
import com.example.devBrief.model.repository.CategoriaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;

    //    GET
    public List<CategoriaResponse> listaTodasCategoria() {
        return repository
                .findAll()
                .stream()
                .map(c -> new CategoriaResponse(c.getNome(), c.getDescricao()))
                .toList();
    }

    //    POST
    public CategoriaEntity salvarCategoria(@Valid CategoriaRequest dto) {
        if (repository.findByNome(dto.getNome()).isPresent())
            throw new IllegalArgumentException("Categoria já existe");

        CategoriaEntity novaCategoria = new CategoriaEntity();
        novaCategoria.setNome(dto.getNome());
        novaCategoria.setDescricao(dto.getDescricao());
        return repository.save(novaCategoria);
    }

    //    PUT
    public CategoriaEntity atualizarCategoria(Long id, @Valid CategoriaRequest dto) {
        CategoriaEntity categoriaExiste = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrado"));
        categoriaExiste.setNome(dto.getNome());
        categoriaExiste.setDescricao(dto.getDescricao());
        return repository.save(categoriaExiste);
    }

    //    DELETE
    public void deletarCategoria(Long id) {
        if (!repository.existsById(id))
            throw new IllegalArgumentException("Categoria não encontrada");

        repository.deleteById(id);
    }
}
