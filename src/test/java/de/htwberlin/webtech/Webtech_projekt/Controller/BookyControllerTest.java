package de.htwberlin.webtech.Webtech_projekt.Controller;


import de.htwberlin.webtech.Webtech_projekt.Entity.Booky;
import de.htwberlin.webtech.Webtech_projekt.Repository.BookyRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookyController.class)
public class BookyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookyRepository bookyRepository;

    @Test
    void testGetAllBooks() throws Exception {
        // Arrange
        Booky book1 = new Booky(1, "Der Herr der Ringe", "J.R.R. Tolkien", 15.99);
        Booky book2 = new Booky(2, "Harry Potter", "J.K. Rowling", 12.49);
        Mockito.when(bookyRepository.findAll()).thenReturn(Arrays.asList(book1, book2));

        // Act & Assert
        mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].title", is("Der Herr der Ringe")))
                .andExpect(jsonPath("$[1].title", is("Harry Potter")));
    }

    @Test
    void testSearchBooks() throws Exception {
        // Arrange
        Booky book = new Booky(1, "Der Herr der Ringe", "J.R.R. Tolkien", 15.99);
        Mockito.when(bookyRepository.findAll()).thenReturn(Arrays.asList(book));

        // Act & Assert
        mockMvc.perform(get("/api/books/search").param("query", "Ringe"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title", is("Der Herr der Ringe")));
    }

    @Test
    void testGetBookById() throws Exception {
        // Arrange
        Booky book = new Booky(1, "Der Herr der Ringe", "J.R.R. Tolkien", 15.99);
        Mockito.when(bookyRepository.findById(1)).thenReturn(Optional.of(book));

        // Act & Assert
        mockMvc.perform(get("/api/books/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("Der Herr der Ringe")));
    }

    @Test
    void testAddBooky() throws Exception {
        // Arrange
        Booky book = new Booky(1, "Der Herr der Ringe", "J.R.R. Tolkien", 15.99);
        Mockito.when(bookyRepository.save(Mockito.any(Booky.class))).thenReturn(book);

        // Act & Assert
        mockMvc.perform(post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{" +
                                "\"title\": \"Der Herr der Ringe\", " +
                                "\"author\": \"J.R.R. Tolkien\", " +
                                "\"price\": 15.99}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title", is("Der Herr der Ringe")));
    }

    @Test
    void testUpdateBook() throws Exception {
        // Arrange
        Booky existingBook = new Booky(1, "Der Herr der Ringe", "J.R.R. Tolkien", 15.99);
        Booky updatedBook = new Booky(1, "Der Hobbit", "J.R.R. Tolkien", 12.99);
        Mockito.when(bookyRepository.findById(1)).thenReturn(Optional.of(existingBook));
        Mockito.when(bookyRepository.save(Mockito.any(Booky.class))).thenReturn(updatedBook);

        // Act & Assert
        mockMvc.perform(put("/api/books/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{" +
                                "\"title\": \"Der Hobbit\", " +
                                "\"author\": \"J.R.R. Tolkien\", " +
                                "\"price\": 12.99}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("Der Hobbit")));
    }

    @Test
    void testDeleteBook() throws Exception {
        // Arrange
        Mockito.when(bookyRepository.existsById(1)).thenReturn(true);

        // Act & Assert
        mockMvc.perform(delete("/api/books/1"))
                .andExpect(status().isNoContent());
    }
}
