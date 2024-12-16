package de.htwberlin.webtech.Webtech_projekt;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/things") // Updated base path
public class ThingController {

    @Autowired
    private BookyRepository bookyRepository;

    public ThingController(BookyRepository bookyRepository) {
        this.bookyRepository = bookyRepository;
    }

    @PostMapping
    public Thing addThing(@RequestBody Thing thing) {
        return bookyRepository.save(thing); // Save to database
    }

    @GetMapping("/{id}")
    public Thing getThing(@PathVariable Long id) {
        return bookyRepository.findById(id) // Retrieve from database
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Thing not found"));
    }

    @GetMapping
    public List<Thing> getAllThings() {
        return bookyRepository.findAll(); // Retrieve all from database
    }
}