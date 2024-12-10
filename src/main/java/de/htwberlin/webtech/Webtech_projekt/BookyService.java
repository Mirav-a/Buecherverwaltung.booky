package de.htwberlin.webtech.Webtech_projekt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookyService {


    // Beispiel-Datenbank (kann später durch eine echte Datenbank ersetzt werden)
    private List<Booky> books = new ArrayList<>();

    public BookyService() {
        // Beispiel-Bücher hinzufügen
        books.add(new Booky(1, "Der Herr der Ringe", "J.R.R. Tolkien", 15.99));
        books.add(new Booky(2, "Harry Potter und der Stein der Weisen", "J.K. Rowling", 12.49));
        books.add(new Booky(3, "Die Verwandlung", "Franz Kafka", 8.99));
    }

    // Methode, um alle Bücher zu erhalten
    public List<Booky> getBooks() {
        return books;
    }

    // Methode, um Bücher basierend auf einer Suchanfrage zu finden
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

    // Methode, um ein Buch zu kaufen (beispielhaft)
    public boolean buyBook(int id) {
        for (Booky book : books) {
            if (book.getId() == id) {
                // Buch kaufen (hier könnte Logik zur Bezahlung eingefügt werden)
                books.remove(book); // Buch aus der Liste entfernen
                return true;
            }
        }
        return false;
    }

    // Neue Methode, um Buchdetails zu erhalten
    public String getBookDetails() {
        if (!books.isEmpty()) {
            Booky book = books.get(0); // Beispielhaft das erste Buch nehmen
            return "Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Price: " + book.getPrice();
        }
        return "No book available";
    }
}