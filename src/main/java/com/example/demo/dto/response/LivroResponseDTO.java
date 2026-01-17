package com.example.demo.dto.response;

import com.example.demo.model.Livro;

public record LivroResponseDTO(Long id, String titulo, String autor, Integer anoPublicacao) {

    public static LivroResponseDTO fromEntity(Livro livro) {

        return new LivroResponseDTO(
                livro.getId(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getAnoPublicacao()
        );

    }
}
