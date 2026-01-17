package com.example.demo.service;

import com.example.demo.dto.request.LivroRequestDTO;
import com.example.demo.dto.response.LivroResponseDTO;
import com.example.demo.model.Livro;
import com.example.demo.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<LivroResponseDTO> findByTitle(String title) {
        return bookRepository.findByTituloContainingIgnoreCase(title)
                .stream()
                .map(LivroResponseDTO::fromEntity)
                .toList();
    }

    public List<LivroResponseDTO> findByAuthor(String Author) {
        return bookRepository.findByAutorContainingIgnoreCase(Author)
                .stream()
                .map(LivroResponseDTO::fromEntity)
                .toList();
    }

    public LivroResponseDTO findById(Long id) throws Exception {
        Livro livro = bookRepository.findById(id)
                .orElseThrow(() -> new Exception("Livro não encontrado"));
        return LivroResponseDTO.fromEntity(livro);
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
        Livro book = bookRepository.findById(id)
                .orElseThrow(() -> new Exception("Livro não encontrado"));

        book.setTitulo(bookRequest.titulo());
        book.setAutor(bookRequest.autor());
        book.setAnoPublicacao(bookRequest.anoPublicacao());

        Livro saved = bookRepository.save(book);
        return LivroResponseDTO.fromEntity(saved);
    }

    public void remove(Long id) throws Exception {
        if (!bookRepository.existsById(id)) {
            throw new Exception("Livro não encontrado");
        }
        bookRepository.deleteById(id);
    }

}
