package de.htwberlin.webtech.Webtech_projekt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Booky/api")
public class BookyController {

    private final BookyService bookyService;

    public BookyController(BookyService bookyService) {
        this.bookyService = bookyService;
    }

    @GetMapping("/books")
    public List<Booky> getAllBooks() {
        return bookyService.getBooks();
    }

    @GetMapping("/books/search")
    public List<Booky> searchBooks(@RequestParam String query) {
        return bookyService.searchBooks(query);
    }
}
