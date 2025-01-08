package de.htwberlin.webtech.Webtech_projekt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SpringBootTest
@WebAppConfiguration
public class WebConfigTest {

    private MockMvc mockMvc;

    @Autowired
    public void setUp(WebApplicationContext context) {
        this.mockMvc = webAppContextSetup(context).build();
    }

    @Test
    void testCorsConfigurationForApiRoutes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.options("/api/test")
                        .header("Origin", "http://localhost:5177")
                        .header("Access-Control-Request-Method", "GET"))
                .andExpect(status().isOk())
                .andExpect(header().string("Access-Control-Allow-Origin", "http://localhost:5177"))
                .andExpect(header().string("Access-Control-Allow-Methods", containsString(HttpMethod.GET.name())))
                .andExpect(header().string("Access-Control-Allow-Credentials", "true"));
    }

    @Test
    void testCorsConfigurationWithInvalidOrigin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.options("/api/test")
                        .header("Origin", "http://invalid-origin.com")
                        .header("Access-Control-Request-Method", "GET"))
                .andExpect(status().isForbidden());
    }
}