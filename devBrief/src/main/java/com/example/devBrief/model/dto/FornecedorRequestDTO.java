package com.example.devBrief.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class FornecedorRequestDTO {

    @NotBlank(message = "O nome é obrigatório.")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres.")
    private String nome;

    @NotBlank(message = "O e-mail é obrigatório.")
    @Size(max = 100, message = "O e-mail deve ter no máximo 100 caracteres.")
    private String email;

    @NotBlank(message = "O telefone é obrigatório.")
    @Size(min = 11, max= 21, message = "O telefone deve ter entre 11 e 21 caracteres.")
    private String telefone;
}