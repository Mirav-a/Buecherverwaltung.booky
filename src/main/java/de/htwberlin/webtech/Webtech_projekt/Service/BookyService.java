package de.htwberlin.webtech.Webtech_projekt.Service;

import org.springframework.stereotype.Service;
import de.htwberlin.webtech.Webtech_projekt.Entity.Booky;
import de.htwberlin.webtech.Webtech_projekt.Repository.BookyRepository;
import java.util.List;

@Service
public class BookyService {
    private final BookyRepository bookyRepository;

    public BookyService(BookyRepository bookyRepository) {
        this.bookyRepository = bookyRepository;
    }

    public List<Booky> getAllBooks() {
        return bookyRepository.findAll();
    }

    public Booky saveBook(Booky booky) {
        return bookyRepository.save(booky);
    }
}
