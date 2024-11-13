package de.htwberlin.webtech.Webtech_projekt;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookyController {
    private final BookyService bookyService;

    public BookyController(BookyService bookyService) {
        this.bookyService = bookyService;
    }

    @GetMapping("/example")
    public String example() {
        return "Beispiel funktioniert!";
    }
}
