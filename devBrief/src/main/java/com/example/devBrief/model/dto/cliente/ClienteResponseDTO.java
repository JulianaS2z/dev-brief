package com.example.devBrief.model.dto.cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ClienteResponseDTO {

    private String nome;
    private String email;
    private String telefone;

}


