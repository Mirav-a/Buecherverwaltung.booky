package de.htwberlin.webtech.Webtech_projekt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookyHtmlController {

    @GetMapping("/")
    public String home() {
        return "Booky"; // Änderung: View muss in templates vorhanden sein
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Änderung: View muss in templates vorhanden sein
    }

    @GetMapping("/register")
    public String register() {
        return "register"; // Änderung: View muss in templates vorhanden sein
    }

    @GetMapping("/zahlung")
    public String zahlung() {
        return "zahlung"; // Änderung: View muss in templates vorhanden sein
    }
}
