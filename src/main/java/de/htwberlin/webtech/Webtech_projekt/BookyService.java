package de.htwberlin.webtech.Webtech_projekt;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookyService {

    private List<Booky> books = new ArrayList<>();

    public BookyService() {
        books.add(new Booky(1, "Der Herr der Ringe", "J.R.R. Tolkien", "https://example.com/images/herr_der_ringe.jpg", 15.99, "Ein epischer Fantasy-Roman", "Verkäufer: Max Mustermann"));
        books.add(new Booky(2, "Harry Potter und der Stein der Weisen", "J.K. Rowling", "https://example.com/images/harry_potter.jpg", 12.49, "Das erste Buch in der Harry Potter Serie", "Verkäufer: Julia Schmidt"));
        books.add(new Booky(3, "Die Verwandlung", "Franz Kafka", "https://example.com/images/verwandlung.jpg", 8.99, "Ein Klassiker der Weltliteratur", "Verkäufer: Franziska Müller"));
    }

    public List<Booky> getBooks() {
        return books;
    }

    public List<Booky> searchBooks(String query) {
        List<Booky> result = new ArrayList<>();
        for (Booky book : books) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(query.toLowerCase()) ||
                    book.getDescription().toLowerCase().contains(query.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    public Booky getBookById(int id) {
        return books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }
}
