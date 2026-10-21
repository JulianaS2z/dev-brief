package com.example.devBrief.controller;

import com.example.devBrief.model.dto.categoria.CategoriaRequest;
import com.example.devBrief.model.dto.categoria.CategoriaResponse;
 // Assumindo que este DTO existe ou será criado
import com.example.devBrief.model.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> listarTodos() {
        return ResponseEntity
                .ok()
                .body(service.listaTodasCategoria());
    }

    @PostMapping
    public ResponseEntity<Map<?,?>> salvar(@Valid @RequestBody CategoriaRequest dto) {
        service.salvarCategoria(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem", "Categoria cadastrada com sucesso"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<?,?>> atualizar(@PathVariable Long id, @Valid @RequestBody CategoriaRequest dto) {
        service.atualizarCategoria(id, dto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // Mantido o padrão CREATED do seu projeto
                .body(Map.of("Mensagem", "Categoria atualizada com sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<?,?>> excluir(@PathVariable Long id) {
        service.deletarCategoria(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Categoria excluída com sucesso"));
    }
}
