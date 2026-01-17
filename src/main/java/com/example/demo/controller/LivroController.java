package com.example.demo.controller;

import com.example.demo.dto.LivroRequestDTO;
import com.example.demo.dto.LivroResponseDTO;
import com.example.demo.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livro")
public class LivroController {

    private final LivroService bookService;

    public LivroController(LivroService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("")
    public ResponseEntity<LivroResponseDTO> createBook(@Valid @RequestBody LivroRequestDTO bookRequest) {
        try {
            LivroResponseDTO book = bookService.create(bookRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(book);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("")
    public ResponseEntity<List<LivroResponseDTO>> listAll() {
        List<LivroResponseDTO> books = bookService.findAll();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponseDTO> findById(@PathVariable Long id){
        try{
            LivroResponseDTO book = bookService.findById(id);
            return ResponseEntity.ok(book);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}
