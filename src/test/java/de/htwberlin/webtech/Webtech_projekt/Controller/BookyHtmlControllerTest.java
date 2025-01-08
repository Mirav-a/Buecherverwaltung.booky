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

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookyController.class)
public class BookyHtmlControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookyRepository bookyRepository;

    @Test
    void testGetAllBooks() throws Exception {
        Booky book1 = new Booky(1, "Title1", "Author1", 10.0);
        Booky book2 = new Booky(2, "Title2", "Author2", 15.0);

        when(bookyRepository.findAll()).thenReturn(Arrays.asList(book1, book2));

        mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Title1"))
                .andExpect(jsonPath("$[1].author").value("Author2"));
    }

    @Test
    void testGetBookById() throws Exception {
        Booky book = new Booky(1, "Title1", "Author1", 10.0);
        when(bookyRepository.findById(1)).thenReturn(Optional.of(book));

        mockMvc.perform(get("/api/books/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Title1"))
                .andExpect(jsonPath("$.price").value(10.0));
    }

    @Test
    void testAddBooky() throws Exception {
        Booky book = new Booky("Title1", "Author1", 10.0);
        when(bookyRepository.save(Mockito.any(Booky.class))).thenReturn(book);

        mockMvc.perform(post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"Title1\",\"author\":\"Author1\",\"price\":10.0}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Title1"));
    }

    @Test
    void testUpdateBook() throws Exception {
        Booky existingBook = new Booky(1, "Old Title", "Old Author", 10.0);
        Booky updatedBook = new Booky(1, "New Title", "New Author", 15.0);

        when(bookyRepository.findById(1)).thenReturn(Optional.of(existingBook));
        when(bookyRepository.save(Mockito.any(Booky.class))).thenReturn(updatedBook);

        mockMvc.perform(put("/api/books/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"New Title\",\"author\":\"New Author\",\"price\":15.0}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("New Title"));
    }

    @Test
    void testDeleteBook() throws Exception {
        when(bookyRepository.existsById(1)).thenReturn(true);
        doNothing().when(bookyRepository).deleteById(1);

        mockMvc.perform(delete("/api/books/1"))
                .andExpect(status().isNoContent());
    }
}