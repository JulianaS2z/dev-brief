package com.example.devBrief.model.dto.avaliacao;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AvaliacaoRequest {

    @NotNull(message = "A nota é obrigatória.")
    @Min(value = 1, message = "A nota mínima permitida é 1.")
    @Max(value = 5, message = "A nota máxima permitida é 5.")
    private Integer nota;

    @NotBlank(message = "O comentário é obrigatório.")
    @Size(min = 5, max = 500, message = "O comentário deve ter entre 5 e 500 caracteres.")
    private String comentario;
}
