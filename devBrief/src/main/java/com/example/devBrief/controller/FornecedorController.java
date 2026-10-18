package com.example.devBrief.controller;

import com.example.devBrief.model.dto.*;
import com.example.devBrief.model.service.FornecedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService service;

    @GetMapping
    public ResponseEntity<List<FornecedorResponseDTO>> listarTodos() {
        return ResponseEntity
                .ok()
                .body(service.listarTodos());
    }

    @GetMapping("/marketing")
    public ResponseEntity<List<FornecedorEmailMarkenting>> listarContatosMarketing() {
        return ResponseEntity
                .ok()
                .body(service.listarContatosMarketing());
    }

    @GetMapping("/whatsapp")
    public ResponseEntity<List<FornecedorWhatsappTelefoneDTO>> listarContatosWhatsapp() {
        return ResponseEntity
                .ok()
                .body(service.listarContatosWhatsapp());
    }

    @PostMapping
    public ResponseEntity<Map<?,?>> salvar(@Valid @RequestBody FornecedorRequestDTO dto) {
        service.salvar(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem", "Fornecedor cadastrado com sucesso"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<?,?>> atualizar(@PathVariable Long id, @Valid @RequestBody FornecedorRequestDTO dto) {
        service.atualizar(id, dto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // Mantido HttpStatus.CREATED conforme o padrão enviado
                .body(Map.of("Mensagem", "Fornecedor atualizado com sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<?,?>> excluir(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Fornecedor excluído com sucesso"));
    }
}
