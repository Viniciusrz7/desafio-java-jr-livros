package com.example.demo.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequestDTO(

        @NotBlank(message = "Email é obrigatório")
        @Size(max = 100, message = "Email deve ter no máximo 100 caracteres")
        @Email(message = "Email deve ser valido")
        String email,

        @NotBlank(message = "Senha é obrigatória")
        String password

) {}
