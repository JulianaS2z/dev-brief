package com.example.devBrief.model.service;

import com.example.devBrief.model.dto.*;
import com.example.devBrief.model.entity.FornecedorEntity;
import com.example.devBrief.model.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    // Read - GET (Todos)
    public List<FornecedorResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(fornecedor -> new FornecedorResponseDTO(fornecedor.getNome(), fornecedor.getEmail(), fornecedor.getTelefone()))
                .toList();
    }

    // Read - GET (Marketing)
    public List<FornecedorEmailMarkenting> listarContatosMarketing() {
        return repository.findAll()
                .stream()
                .map(fornecedor -> new FornecedorEmailMarkenting(fornecedor.getNome(), fornecedor.getEmail()))
                .toList();
    }

    // Read - GET (WhatsApp)
    public List<FornecedorWhatsappTelefoneDTO> listarContatosWhatsapp() {
        return repository.findAll()
                .stream()
                .map(fornecedor -> new FornecedorWhatsappTelefoneDTO(fornecedor.getNome(), fornecedor.getTelefone()))
                .toList();
    }

    // Insert - POST
    public FornecedorEntity salvar(FornecedorRequestDTO dto) {
        if (repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Fornecedor já cadastrado.");
        }

        FornecedorEntity novoFornecedor = new FornecedorEntity();
        novoFornecedor.setNome(dto.getNome());
        novoFornecedor.setEmail(dto.getEmail());
        novoFornecedor.setTelefone(dto.getTelefone());
        return repository.save(novoFornecedor);
    }

    // Update - PUT
    public FornecedorEntity atualizar(Long id, FornecedorRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Fornecedor não encontrado.");
        }

        FornecedorEntity novoFornecedor = new FornecedorEntity();
        novoFornecedor.setId(id);
        novoFornecedor.setNome(dto.getNome());
        novoFornecedor.setEmail(dto.getEmail());
        novoFornecedor.setTelefone(dto.getTelefone());

        return repository.save(novoFornecedor);
    }

    // Delete - DELETE
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Fornecedor não encontrado.");
        }

        repository.deleteById(id);
    }
}
