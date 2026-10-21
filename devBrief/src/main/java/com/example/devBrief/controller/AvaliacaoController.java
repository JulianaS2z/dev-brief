package com.example.devBrief.controller;

import com.example.devBrief.model.dto.avaliacao.AvaliacaoRequest;
import com.example.devBrief.model.dto.avaliacao.AvaliacaoResponse;
import com.example.devBrief.model.service.AvaliacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService service;

    @GetMapping
    public ResponseEntity<List<AvaliacaoResponse>> listarTodos() {
        return ResponseEntity
                .ok()
                .body(service.listTodasAvaliacao());
    }

    @PostMapping
    public ResponseEntity<Map<?,?>> salvar(@Valid @RequestBody AvaliacaoRequest dto) {
        service.salvarAvaliacao(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem", "Avaliação cadastrada com sucesso"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<?,?>> atualizar(@PathVariable Long id, @Valid @RequestBody AvaliacaoRequest dto) {
        service.atualizarAvaliacao(id, dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem", "Avaliação atualizada com sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<?,?>> excluir(@PathVariable Long id) {
        service.deletarAvaliacao(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Avaliação excluída com sucesso"));
    }
}
