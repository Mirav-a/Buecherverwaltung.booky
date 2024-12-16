package de.htwberlin.webtech.Webtech_projekt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookyHtmlController {

    @GetMapping("/")
    public String home() {
        return "Booky"; // Verweist auf Booky.html
    }


    @GetMapping("/login")
    public String login() {
        return "login"; // Verweist auf login.html
    }

    @GetMapping("/register")
    public String register() {
        return "register"; // Verweist auf register.html
    }

    @GetMapping("/zahlung")
    public String zahlung() {
        return "zahlung"; // Verweist auf zahlung.html
    }

}