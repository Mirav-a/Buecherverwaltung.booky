package de.htwberlin.webtech.Webtech_projekt;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow CORS requests from your frontend domain (localhost:5177)
        registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE","OPTIONS");
        registry.addMapping("/api/**") // Apply to all API routes
                .allowedOrigins("http://localhost:5173","https://buecherverwaltung-frontend.onrender.com") // Allow the frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow specific HTTP methods
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(true); // Allow credentials (cookies, etc.)
    }
}
