package com.example.devBrief.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tab_fornecedor")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class FornecedorEntity {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String telefone;

}