package com.example.demo.service;

import com.example.demo.dto.LivroResponseDTO;
import com.example.demo.model.Livro;
import com.example.demo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {

    public final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepo) {
        this.livroRepository = livroRepo;
    }

    public List<LivroResponseDTO> findAll() {
        return livroRepository.findAll()
                .stream()
                .map(LivroResponseDTO::fromEntity)
                .toList();
    }

}
