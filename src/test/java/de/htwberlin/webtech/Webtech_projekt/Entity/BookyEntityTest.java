package de.htwberlin.webtech.Webtech_projekt.Entity;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest // Starts an in-memory database for testing JPA
class BookyEntityTest {

    @Autowired
    private EntityManager entityManager;

    @Test
    void testPersistBookyEntity() {
        // Arrange
        Booky book = new Booky("Der Herr der Ringe", "J.R.R. Tolkien", 15.99);

        // Act
        entityManager.persist(book);
        entityManager.flush();

        // Assert
        assertThat(book.getId()).isGreaterThan(0);
    }

    @Test
    void testPersistBookyWithNullTitleShouldFail() {
        // Arrange
        Booky book = new Booky(null, "J.R.R. Tolkien", 15.99);

        // Act & Assert
        assertThrows(PersistenceException.class, () -> {
            entityManager.persist(book);
            entityManager.flush();
        });
    }

    @Test
    void testPersistBookyWithNullAuthorShouldFail() {
        // Arrange
        Booky book = new Booky("Der Herr der Ringe", null, 15.99);

        // Act & Assert
        assertThrows(PersistenceException.class, () -> {
            entityManager.persist(book);
            entityManager.flush();
        });
    }

    @Test
    void testPersistBookyWithNegativePriceShouldPass() {
        // Arrange
        Booky book = new Booky("Der Hobbit", "J.R.R. Tolkien", -5.99);

        // Act
        entityManager.persist(book);
        entityManager.flush();

        // Assert
        assertThat(book.getId()).isGreaterThan(0);
    }

    @Test
    void testPersistBookyWithDuplicateDataShouldPass() {
        // Arrange
        Booky book1 = new Booky("Harry Potter", "J.K. Rowling", 12.49);
        Booky book2 = new Booky("Harry Potter", "J.K. Rowling", 12.49);

        // Act
        entityManager.persist(book1);
        entityManager.persist(book2);
        entityManager.flush();

        // Assert
        assertThat(book1.getId()).isNotEqualTo(book2.getId());
    }
}