package com.example.devBrief.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice // Altere de @RestController para @RestControllerAdvice
public class GlobalException {

    // Captura erros de regras de negócio lançados com IllegalArgumentException (ex: Cliente/Fornecedor já cadastrado)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> tratarIllegalArgumentException(IllegalArgumentException erro) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("mensagem", erro.getMessage()));
    }

    // Captura erros de validação (@Valid, @NotBlank, @Size) e esconde o erro gigante do Spring
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> tratarValidacoes(MethodArgumentNotValidException erro) {
        Map<String, String> errosCampos = new HashMap<>();

        // Mapeia apenas o nome do campo e a mensagem customizada que você definiu no DTO
        for (FieldError fieldError : erro.getBindingResult().getFieldErrors()) {
            errosCampos.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        Map<String, Object> resposta = new HashMap<>();
        resposta.put("mensagem", "Erro de validação nos campos preenchidos.");
        resposta.put("erros", errosCampos);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(resposta);
    }
}