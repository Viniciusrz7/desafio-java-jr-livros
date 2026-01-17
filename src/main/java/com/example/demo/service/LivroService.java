package com.example.demo.service;

import com.example.demo.dto.LivroRequestDTO;
import com.example.demo.dto.LivroResponseDTO;
import com.example.demo.model.Livro;
import com.example.demo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {

    public final LivroRepository bookRepository;

    public LivroService(LivroRepository livroRepo) {
        this.bookRepository = livroRepo;
    }

    public List<LivroResponseDTO> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(LivroResponseDTO::fromEntity)
                .toList();
    }

    public LivroResponseDTO create(LivroRequestDTO livroRequest) {
        Livro book = new Livro();
        book.setTitulo(livroRequest.titulo());
        book.setAutor(livroRequest.autor());
        book.setAnoPublicacao(livroRequest.anoPublicacao());

        Livro saved = bookRepository.save(book);
        return LivroResponseDTO.fromEntity(saved);
    }

}
