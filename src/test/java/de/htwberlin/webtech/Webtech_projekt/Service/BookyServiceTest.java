package de.htwberlin.webtech.Webtech_projekt.Service;


import de.htwberlin.webtech.Webtech_projekt.Entity.Booky;
import de.htwberlin.webtech.Webtech_projekt.Repository.BookyRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class BookyServiceTest {

    private final BookyRepository bookyRepository = Mockito.mock(BookyRepository.class);
    private final BookyService bookyService = new BookyService(bookyRepository);

    @Test
    void testGetAllBooks() {
        // Arrange
        Booky book1 = new Booky(1, "Der Herr der Ringe", "J.R.R. Tolkien", 15.99);
        Booky book2 = new Booky(2, "Harry Potter", "J.K. Rowling", 12.49);
        Mockito.when(bookyRepository.findAll()).thenReturn(Arrays.asList(book1, book2));

        // Act
        List<Booky> books = bookyService.getAllBooks();

        // Assert
        assertEquals(2, books.size());
        assertEquals("Der Herr der Ringe", books.get(0).getTitle());
        assertEquals("Harry Potter", books.get(1).getTitle());
    }

    @Test
    void testSaveBook() {
        // Arrange
        Booky book = new Booky(1, "Der Herr der Ringe", "J.R.R. Tolkien", 15.99);
        Mockito.when(bookyRepository.save(any(Booky.class))).thenReturn(book);

        // Act
        Booky savedBook = bookyService.saveBook(book);

        // Assert
        assertEquals("Der Herr der Ringe", savedBook.getTitle());
        assertEquals("J.R.R. Tolkien", savedBook.getAuthor());
        assertEquals(15.99, savedBook.getPrice());
    }
}