package de.htwberlin.webtech.Webtech_projekt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookyRepository extends JpaRepository<Thing, Long> {
    // Optional: Custom Queries können hier hinzugefügt werden
}
