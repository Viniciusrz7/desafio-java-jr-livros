package com.example.demo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LivroRequestDTO(

        @NotBlank(message = "Titulo não pode ser vazio")
        @Size(max = 200, message = "Titulo deve ter no máximo 200 caracteres")
        String titulo,

        @NotBlank(message = "Autor não pode ser vazio")
        @Size(max = 150, message = "Autor deve ter no máximo 150 caracteres")
        String autor,

        @NotNull(message = "Ano de publicação é obrigatório")
        @Max(value = 2026, message = "Ano de publicação não pode ser no futuro")
        Integer anoPublicacao

) {}
