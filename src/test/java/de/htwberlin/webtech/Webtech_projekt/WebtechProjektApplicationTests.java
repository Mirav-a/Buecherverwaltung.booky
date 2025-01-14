package de.htwberlin.webtech.Webtech_projekt;

import de.htwberlin.webtech.Webtech_projekt.Repository.BookyRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest // Lädt den gesamten Anwendungskontext
@AutoConfigureMockMvc // Aktiviert MockMvc
public class WebtechProjektApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookyRepository bookyRepository;

	@Test
	public void testGetAllBooks() throws Exception {
		// Simuliere das Verhalten des Repositorys
		Mockito.when(bookyRepository.findAll()).thenReturn(java.util.Collections.emptyList());

		// Teste den Endpunkt "/api/books"
		mockMvc.perform(get("/api/books"))
				.andExpect(status().isOk()) // Erwarteter Status 200 OK
				.andExpect(content().string("[]")); // Da keine Bücher vorhanden sind, ist die Antwort ein leeres Array
	}
}