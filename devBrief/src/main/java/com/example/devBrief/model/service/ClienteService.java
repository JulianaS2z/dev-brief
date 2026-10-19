package com.example.devBrief.model.service;


import com.example.devBrief.model.dto.*;
import com.example.devBrief.model.dto.cliente.ClienteEmailMarkenting;
import com.example.devBrief.model.dto.cliente.ClienteRequestDTO;
import com.example.devBrief.model.dto.cliente.ClienteResponseDTO;
import com.example.devBrief.model.dto.cliente.ClienteWhatsappTelefoneDTO;
import com.example.devBrief.model.entity.ClienteEntity;
import com.example.devBrief.model.entity.FornecedorEntity;
import com.example.devBrief.model.repository.ClienteRepository;
import com.example.devBrief.model.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    // Read - GET (Todos)
    public List<ClienteResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(cliente -> new ClienteResponseDTO(cliente.getNome(), cliente.getEmail(), cliente.getTelefone()))
                .toList();
    }

    // Read - GET (Marketing)
    public List<ClienteEmailMarkenting> listarContatosMarketing() {
        return repository.findAll()
                .stream()
                .map(cliente -> new ClienteEmailMarkenting(cliente.getNome(), cliente.getEmail()))
                .toList();
    }

    // Read - GET (WhatsApp)
    public List<ClienteWhatsappTelefoneDTO> listarContatosWhatsapp() {
        return repository.findAll()
                .stream()
                .map(cliente -> new ClienteWhatsappTelefoneDTO(cliente.getNome(), cliente.getTelefone()))
                .toList();
    }

    // Insert - POST
    public ClienteEntity salvar(ClienteRequestDTO dto) {
        if (repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Cliente já cadastrado.");
        }

        ClienteEntity novoCliente = new ClienteEntity();
        novoCliente.setNome(dto.getNome());
        novoCliente.setEmail(dto.getEmail());
        novoCliente.setTelefone(dto.getTelefone());

        return repository.save(novoCliente);
    }

    // Update - PUT
    public ClienteEntity atualizar(Long id, ClienteRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }

        ClienteEntity novoCliente = new ClienteEntity();
        novoCliente.setId(id);
        novoCliente.setNome(dto.getNome());
        novoCliente.setEmail(dto.getEmail());
        novoCliente.setTelefone(dto.getTelefone());

        return repository.save(novoCliente);
    }

    // Delete - DELETE
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }
        repository.deleteById(id);
    }


}
