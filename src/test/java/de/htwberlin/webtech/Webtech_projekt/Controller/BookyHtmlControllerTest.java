package de.htwberlin.webtech.Webtech_projekt.Controller;

import de.htwberlin.webtech.Webtech_projekt.Controller.BookyHtmlController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookyHtmlController.class)
class BookyHtmlControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHomeEndpoint() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("Booky"));
    }

    @Test
    void testLoginEndpoint() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("login"));
    }

    @Test
    void testRegisterEndpoint() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("register"));
    }

    @Test
    void testZahlungEndpoint() throws Exception {
        mockMvc.perform(get("/zahlung"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("zahlung"));
    }
}