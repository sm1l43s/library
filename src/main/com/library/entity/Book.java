package main.com.library.entity;

public class Book {

    private int id;
    private String name;
    private Long yearPublish;
    private int quantity;
    private Author author;

    public Book(String name, Long yearPublish, int quantity, Author author) {
        this.name = name;
        this.yearPublish = yearPublish;
        this.quantity = quantity;
        this.author = author;
    }

    public Book(int id, String name, Long yearPublish, int quantity, Author author) {
        this.id = id;
        this.name = name;
        this.yearPublish = yearPublish;
        this.quantity = quantity;
        this.author = author;
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
