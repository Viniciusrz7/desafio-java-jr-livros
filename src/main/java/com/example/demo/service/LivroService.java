package com.example.demo.service;

import com.example.demo.dto.LivroRequestDTO;
import com.example.demo.dto.LivroResponseDTO;
import com.example.demo.model.Livro;
import com.example.demo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    public final LivroRepository bookRepository;

    public LivroService(LivroRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<LivroResponseDTO> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(LivroResponseDTO::fromEntity)
                .toList();
    }

    public LivroResponseDTO create(LivroRequestDTO bookRequest) {
        Livro book = new Livro();
        book.setTitulo(bookRequest.titulo());
        book.setAutor(bookRequest.autor());
        book.setAnoPublicacao(bookRequest.anoPublicacao());

        Livro saved = bookRepository.save(book);
        return LivroResponseDTO.fromEntity(saved);
    }

    public LivroResponseDTO update(Long id, LivroRequestDTO bookRequest) throws Exception {
        if (!bookRepository.existsById(id)) throw new Exception("Livro não encontrado");

        Livro book = bookRepository.findById(id).get();
        book.setTitulo(bookRequest.titulo());
        book.setAutor(bookRequest.autor());
        book.setAnoPublicacao(bookRequest.anoPublicacao());

        Livro saved = bookRepository.save(book);
        return LivroResponseDTO.fromEntity(saved);
    }



}
