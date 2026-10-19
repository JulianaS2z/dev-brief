package com.example.devBrief.controller;




import com.example.devBrief.model.dto.cliente.ClienteEmailMarkenting;
import com.example.devBrief.model.dto.cliente.ClienteRequestDTO;
import com.example.devBrief.model.dto.cliente.ClienteResponseDTO;
import com.example.devBrief.model.dto.cliente.ClienteWhatsappTelefoneDTO;
import com.example.devBrief.model.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listarTodos() {
        return ResponseEntity
                .ok()
                .body(service.listarTodos());
    }

    @GetMapping("/marketing")
    public ResponseEntity<List<ClienteEmailMarkenting>> listarContatosMarketing() {
        return ResponseEntity
                .ok()
                .body(service.listarContatosMarketing());
    }

    @GetMapping("/whatsapp")
    public ResponseEntity<List<ClienteWhatsappTelefoneDTO>> listarContatosWhatsapp() {
        return ResponseEntity
                .ok()
                .body(service.listarContatosWhatsapp());
    }

    @PostMapping
    public ResponseEntity<Map<?,?>> salvar(@Valid @RequestBody ClienteRequestDTO dto) {
        service.salvar(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem", "Cliente cadastrado com sucesso"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<?,?>> atualizar(@PathVariable Long id, @Valid @RequestBody ClienteRequestDTO dto) {
        service.atualizar(id, dto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // Mantido HttpStatus.CREATED conforme o seu padrão
                .body(Map.of("Mensagem", "Cliente atualizado com sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<?,?>> excluir(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Cliente excluído com sucesso"));
    }

}
