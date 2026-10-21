package com.example.devBrief.model.dto.avaliacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AvaliacaoResponse {

    private Integer nota;

    private String comentario;

    private LocalDateTime dataCriacao = LocalDateTime.now();

//    private ClienteEntity cliente;
//
//    private ProdutoEntity produto;
}
