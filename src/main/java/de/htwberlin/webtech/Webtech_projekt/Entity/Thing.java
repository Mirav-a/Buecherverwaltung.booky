package de.htwberlin.webtech.Webtech_projekt.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "thing") // Maps the class to the "thing" table in the database
public class Thing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private int id;

    @Column(nullable = false) // Name column cannot be null
    private String name;

    @Column(nullable = false) // Price column cannot be null
    private int price;

    // Default constructor (required by Hibernate)
    public Thing() {
    }

    // Constructor
    public Thing(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
