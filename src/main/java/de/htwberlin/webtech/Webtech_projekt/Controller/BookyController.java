package de.htwberlin.webtech.Webtech_projekt.Controller;

import de.htwberlin.webtech.Webtech_projekt.Entity.Booky;
import de.htwberlin.webtech.Webtech_projekt.Repository.BookyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "http://localhost:5177")
public class BookyController {

    private final BookyRepository bookyRepository;

    // Constructor-based dependency injection
    public BookyController(BookyRepository bookyRepository) {
        this.bookyRepository = bookyRepository;
    }

    // Get all books
    @GetMapping
    public List<Booky> getAllBooks() {
        return bookyRepository.findAll();
    }

    // Search for books by title or author
    @GetMapping("/search")
    public List<Booky> searchBooks(@RequestParam String query) {
        return bookyRepository.findAll().stream()
                .filter(book -> book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                        book.getAuthor().toLowerCase().contains(query.toLowerCase()))
                .toList();
    }

    // Get a single book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Booky> getBookById(@PathVariable int id) {
        return bookyRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new book
    // Add a new Booky
    @PostMapping
    public ResponseEntity<Booky> addBooky(@RequestBody Booky booky) {
        Booky savedBooky = bookyRepository.save(booky);
        return new ResponseEntity<>(savedBooky, HttpStatus.CREATED);
    }

    // Update an existing book
    @PutMapping("/{id}")
    public ResponseEntity<Booky> updateBook(@PathVariable int id, @RequestBody Booky updatedBooky) {
        return bookyRepository.findById(id).map(existingBook -> {
            existingBook.setTitle(updatedBooky.getTitle());
            existingBook.setAuthor(updatedBooky.getAuthor());
            existingBook.setPrice(updatedBooky.getPrice());
            return ResponseEntity.ok(bookyRepository.save(existingBook));
        }).orElse(ResponseEntity.notFound().build());
    }

    // Delete a book by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        if (bookyRepository.existsById(id)) {
            bookyRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
