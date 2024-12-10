package de.htwberlin.webtech.Webtech_projekt;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api/things") // Updated base path
public class ThingController {

    private List<Thing> things = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(1);

    @PostMapping
    public Thing addThing(@RequestBody Thing thing) {
        thing.setId(idCounter.getAndIncrement());
        things.add(thing);
        return thing;
    }

    @GetMapping("/{id}")
    public Thing getThing(@PathVariable int id) {
        return things.stream()
                .filter(thing -> thing.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Thing not found"));
    }

    @GetMapping
    public List<Thing> getAllThings() {
        return things;
    }
}
