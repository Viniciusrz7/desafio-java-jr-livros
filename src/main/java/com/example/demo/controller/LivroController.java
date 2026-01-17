package com.example.demo.controller;

import com.example.demo.dto.request.LivroRequestDTO;
import com.example.demo.dto.response.LivroResponseDTO;
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

    @GetMapping("/title/{title}")
    public ResponseEntity<List<LivroResponseDTO>> findByTitle(@PathVariable String title) {
        List<LivroResponseDTO> books = bookService.findByTitle(title);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<LivroResponseDTO>> findByAuthor(@PathVariable String author) {
        List<LivroResponseDTO> books = bookService.findByAuthor(author);
        return ResponseEntity.ok(books);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroResponseDTO> updateBook(@PathVariable Long id,
                                                       @Valid @RequestBody LivroRequestDTO bookRequest){
        try{
            LivroResponseDTO book = bookService.update(id,bookRequest);
            return ResponseEntity.ok(book);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        try{
            bookService.remove(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

}
