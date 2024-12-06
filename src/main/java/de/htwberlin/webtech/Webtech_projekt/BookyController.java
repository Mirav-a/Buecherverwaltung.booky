package de.htwberlin.webtech.Webtech_projekt;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookyController {

    private final BookyService bookyService; // Verbindung zum BookyService hergestellt

    // Konstruktor-Injection des BookyService
    public BookyController(BookyService bookyService) {
        this.bookyService = bookyService; // Dependency wird durch Spring Boot verwaltet
    }

    @GetMapping("/books")
    public List<Booky> getAllBooks() {
        return bookyService.getBooks(); // Bücher über den Service abrufen
    }

    @GetMapping("/books/search")
    public List<Booky> searchBooks(@RequestParam String query) {
        return bookyService.searchBooks(query); // Suchanfrage an den Service weiterleiten
    }

    @GetMapping
    public String getBooky() {
        return "Booky - Willkommen bei Booky!";
    }

    @PostMapping("/books/buy")
    public ResponseEntity<?> buyBook(@RequestParam int id) {
        boolean success = bookyService.buyBook(id); // Kauf über den Service ausführen
        if (success) {
            return ResponseEntity.ok("Buch erfolgreich gekauft");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Buch konnte nicht gekauft werden");
        }
    }
}
