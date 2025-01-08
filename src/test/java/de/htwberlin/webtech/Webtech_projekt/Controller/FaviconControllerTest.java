package de.htwberlin.webtech.Webtech_projekt.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FaviconController.class)
class FaviconControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testFaviconRequestReturnsNoContent() throws Exception {
        // Send a GET request to /favicon.ico
        mockMvc.perform(get("/favicon.ico"))
                .andExpect(status().isOk()) // Ensure the status is 200 OK
                .andExpect(result -> {
                    // Ensure no content is returned
                    assert result.getResponse().getContentAsString().isEmpty();
                });
    }
}