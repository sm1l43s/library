package main.com.library.entity;

import java.util.List;

public class Book {

    private int id;
    private String name;
    private Long yearPublish;
    private int quantity;
    private Author author;

    private List<Genres> genres;

    public Book(int id, String name, Long yearPublish, int quantity, Author author) {
        this.id = id;
        this.name = name;
        this.yearPublish = yearPublish;
        this.quantity = quantity;
        this.author = author;
    }

    public Book(int id, String name, Long yearPublish, int quantity, Author author, List<Genres> genres) {
        this.id = id;
        this.name = name;
        this.yearPublish = yearPublish;
        this.quantity = quantity;
        this.author = author;
        this.genres = genres;
    }

    public Book(int id, String name, Long yearPublish, int quantity) {
        this.id = id;
        this.name = name;
        this.yearPublish = yearPublish;
        this.quantity = quantity;
        this.author = null;
        this.genres = null;
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

    public Long getYearPublish() {
        return yearPublish;
    }

    public void setYearPublish(Long yearPublish) {
        this.yearPublish = yearPublish;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Genres> getGenres() {
        return genres;
    }

    public void setGenres(List<Genres> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearPublish=" + yearPublish +
                ", quantity=" + quantity +
                '}';
    }
}
