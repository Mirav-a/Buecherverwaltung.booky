package de.htwberlin.webtech.Webtech_projekt;

import de.htwberlin.webtech.Webtech_projekt.Controller.BookyController;
import de.htwberlin.webtech.Webtech_projekt.Service.BookyService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(BookyController.class) // Testet nur den BookyController
public class WebtechProjektApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookyService bookyService;

	@Test
	public void testGetBooky() throws Exception {
		// Simuliere das Verhalten des Service
		Mockito.when(bookyService.toString()).thenReturn("Booky - Willkommen bei Booky!");

		// Teste den Controller-Endpunkt
		mockMvc.perform(get("/api")) // Pfad des Controllers
				.andExpect(status().isOk()) // Erwarteter Status
				.andExpect(content().string("Booky - Willkommen bei Booky!")); // Erwarteter Inhalt
	}
}
