package com.example.demo.dto.request;

import com.example.demo.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterUserRequestDTO(

        @NotBlank(message = "Nome é obrigatório")
        @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
        String name,

        @NotBlank(message = "Email é obrigatório")
        @Size(max = 100, message = "Email deve ter no máximo 100 caracteres")
        @Email(message = "Email deve ser valido")
        String email,

        @NotBlank(message = "Senha é obrigatória")
        String password,

        @NotBlank User.Role role

) {}
