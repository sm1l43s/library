package main.com.library.entity;

import java.util.List;

public class Author {

    private int id;
    private String name;
    private List<Author> author;

    public Author(String name, List<Author> author) {
        this.name = name;
        this.author = author;
    }

    public Author(int id, String name, List<Author> author) {
        this.id = id;
        this.name = name;
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

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author +
                '}';
    }
}
