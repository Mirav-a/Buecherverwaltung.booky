package de.htwberlin.webtech.Webtech_projekt;

public class Thing {
    private int id;
    private String name;
    private int price;

    // Constructor
    public Thing(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getter und Setter
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

