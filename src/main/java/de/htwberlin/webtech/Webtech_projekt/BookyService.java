package de.htwberlin.webtech.Webtech_projekt;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookyService {

    private List<Booky> books = new ArrayList<>();

    public BookyService() {
        books.add(new Booky(1, "Der Herr der Ringe", "J.R.R. Tolkien", 15.99));
        books.add(new Booky(2, "Harry Potter und der Stein der Weisen", "J.K. Rowling", 12.49));
        books.add(new Booky(3, "Die Verwandlung", "Franz Kafka", 8.99));
    }

    public List<Booky> getBooks() {
        return books;
    }

    public List<Booky> searchBooks(String query) {
        List<Booky> result = new ArrayList<>();
        for (Booky book : books) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(query.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    public boolean buyBook(int id) {
        for (Booky book : books) {
            if (book.getId() == id) {
                books.remove(book);
                return true;
            }
        }
        return false;
    }
}
