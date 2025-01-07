package de.htwberlin.webtech.Webtech_projekt.Repository;
import  de.htwberlin.webtech.Webtech_projekt.Entity.Booky;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookyRepository extends JpaRepository<Booky, Integer> {
}
