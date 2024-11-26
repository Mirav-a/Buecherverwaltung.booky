package de.htwberlin.webtech.Webtech_projekt;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.extension.ExtendWith;

import de.htwberlin.webtech.Webtech_projekt.BookyController;
import de.htwberlin.webtech.Webtech_projekt.BookyService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BookyController.class)
public class WebtechProjektApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookyService bookyService;

	@TestConfiguration
	static class TestConfig {
		@Bean
		public BookyService bookyService() {
			return new BookyService();
		}
	}

	@Test
	public void testGetBooky() throws Exception {
		// Test den existierenden Controller-Endpunkt
		mockMvc.perform(get(""))
				.andExpect(status().isOk())
				.andExpect(content().string("Booky - Willkommen bei Booky!")); // Überprüfe die erwartete Rückgabe
	}

}
