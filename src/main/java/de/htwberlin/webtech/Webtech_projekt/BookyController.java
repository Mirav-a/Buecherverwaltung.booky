package de.htwberlin.webtech.Webtech_projekt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api") // Basis-URL hinzugefügt
public class BookyController {

    private final List<Booky> books = new ArrayList<>();

    public BookyController() {
        books.add(new Booky(1, "Der Herr der Ringe", "J.R.R. Tolkien", 15.99));
        books.add(new Booky(2, "Harry Potter und der Stein der Weisen", "J.K. Rowling", 12.49));
        books.add(new Booky(3, "Die Verwandlung", "Franz Kafka", 8.99));
    }

    @GetMapping("/books")
    public List<Booky> getAllBooks() {
        return books;
    }

    @GetMapping("/books/search")
    public List<Booky> searchBooks(@RequestParam String query) {
        List<Booky> result = new ArrayList<>();
        for (Booky book : books) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(query.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    @GetMapping() // Änderung: Route explizit leer gelassen
    public String getBooky() {
        return "Booky - Willkommen bei Booky!";
    }

    @GetMapping("/test-db")
    public String testDbConnection() {
        System.out.println("Endpunkt wurde aufgerufen!");
        return "Database connected successfully!";
    }

}