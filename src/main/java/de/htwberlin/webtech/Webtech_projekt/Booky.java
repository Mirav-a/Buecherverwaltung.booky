package de.htwberlin.webtech.Webtech_projekt;

public class Booky {
    private int id;
    private String title;
    private String author;
    private String imageUrl;
    private double price;
    private String description;
    private String sellerProfile;

    public Booky(int id, String title, String author, String imageUrl, double price, String description, String sellerProfile) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.imageUrl = imageUrl;
        this.price = price;
        this.description = description;
        this.sellerProfile = sellerProfile;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getSellerProfile() {
        return sellerProfile;
    }
}
