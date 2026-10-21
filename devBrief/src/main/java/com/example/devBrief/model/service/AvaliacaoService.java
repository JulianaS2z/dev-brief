package com.example.devBrief.model.service;


import com.example.devBrief.model.dto.avaliacao.AvaliacaoRequest;
import com.example.devBrief.model.dto.avaliacao.AvaliacaoResponse;
import com.example.devBrief.model.entity.AvaliacaoEntity;
import com.example.devBrief.model.repository.AvaliacaoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {
    @Autowired
    private AvaliacaoRepository repository;

    //    GET
    public List<AvaliacaoResponse> listTodasAvaliacao() {
        return repository
                .findAll()
                .stream()
                .map(a -> new  AvaliacaoResponse(a.getNota(),a.getComentario(),a.getDataCriacao()))
                .toList();
    }

    //    POST
    public AvaliacaoEntity salvarAvaliacao(@Valid AvaliacaoRequest dto) {
        AvaliacaoEntity novaavaliacao = new AvaliacaoEntity();
        novaavaliacao.setNota(dto.getNota());
        novaavaliacao.setComentario(dto.getComentario());
        return repository.save(novaavaliacao);
    }

    //    PUT
    public AvaliacaoEntity atualizarAvaliacao(Long id, @Valid AvaliacaoRequest dto) {
        AvaliacaoEntity avaliacaoExiste = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Avaliação não encontra"));
        avaliacaoExiste.setNota(dto.getNota());
        avaliacaoExiste.setComentario(dto.getComentario());
        return repository.save(avaliacaoExiste);
    }

    //    DELETE
    public void deletarAvaliacao(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Avaliação não encontra");
        }
        repository.existsById(id);
    }
}
