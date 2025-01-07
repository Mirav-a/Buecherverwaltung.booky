package de.htwberlin.webtech.Webtech_projekt.Entity;

import jakarta.persistence.*; // Use `jakarta.persistence` for JPA annotations
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // Marks this class as a JPA Entity
//@Table(name = "booky") // Maps to the "booky" table in the database
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Booky {
    // Constructor
    public Booky(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment strategy
    private int id;

    @Column(nullable = false) // Makes this column non-null
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private double price;
}
