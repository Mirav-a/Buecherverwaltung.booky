package de.htwberlin.webtech.Webtech_projekt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookyHtmlController {

    private final BookyService bookyService;

    @Autowired
    public BookyHtmlController(BookyService bookyService) {
        this.bookyService = bookyService;
    }

    @GetMapping("/booky")
    public String showBooky(Model model) {
        List<Booky> bookies = bookyService.getAllBookies();
        model.addAttribute("booky", bookies);  // "bookies" wird in der HTML-Seite verwendet
        return "booky";  // Der Name der HTML-Datei ohne .html
    }
}

