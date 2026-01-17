package com.example.demo.controller;

import com.example.demo.dto.LivroRequestDTO;
import com.example.demo.dto.LivroResponseDTO;
import com.example.demo.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/livro")
public class LivroController {

    private final LivroService bookService;

    public LivroController(LivroService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("")
    public ResponseEntity<LivroResponseDTO> createBook(@Valid @RequestBody LivroRequestDTO bookRequest){
        try{
            LivroResponseDTO book = bookService.create(bookRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(book);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
