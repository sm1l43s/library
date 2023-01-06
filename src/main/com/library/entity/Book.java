package main.com.library.entity;

import java.util.Date;
import java.util.List;

public class Book {

    private int id;
    private String name;
    private Date yearPublish;
    private int quantity;
    private Subscription subscription;
    private List<Genres> genres;
    private List<Author> authors;

    public Book(String name, Date yearPublish, int quantity,
                Subscription subscription, List<Genres> genres, List<Author> authors) {
        this.name = name;
        this.yearPublish = yearPublish;
        this.quantity = quantity;
        this.subscription = subscription;
        this.genres = genres;
        this.authors = authors;
    }

    public Book(int id, String name, Date yearPublish, int quantity,
                Subscription subscription, List<Genres> genres, List<Author> authors) {
        this.id = id;
        this.name = name;
        this.yearPublish = yearPublish;
        this.quantity = quantity;
        this.subscription = subscription;
        this.genres = genres;
        this.authors = authors;
    }

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

    public Date getYearPublish() {
        return yearPublish;
    }

    public void setYearPublish(Date yearPublish) {
        this.yearPublish = yearPublish;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public List<Genres> getGenres() {
        return genres;
    }

    public void setGenres(List<Genres> genres) {
        this.genres = genres;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearPublish=" + yearPublish +
                ", quantity=" + quantity +
                ", subscription=" + subscription +
                ", genres=" + genres +
                ", authors=" + authors +
                '}';
    }
}
