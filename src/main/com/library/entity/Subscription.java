package main.com.library.entity;

import java.util.Date;

public class Subscription {

    private int id;
    private Subscriber subscriber;
    private Book book;
    private Date start;
    private Date finish;
    private boolean isActive;

    public Subscription(Subscriber subscriber, Book book, Date start, Date finish, boolean isActive) {
        this.subscriber = subscriber;
        this.book = book;
        this.start = start;
        this.finish = finish;
        this.isActive = isActive;
    }

    public Subscription(int id, Subscriber subscriber, Book book, Date start, Date finish, boolean isActive) {
        this.id = id;
        this.subscriber = subscriber;
        this.book = book;
        this.start = start;
        this.finish = finish;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getFinish() {
        return finish;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", subscriber=" + subscriber +
                ", book=" + book +
                ", start=" + start +
                ", finish=" + finish +
                ", isActive=" + isActive +
                '}';
    }
}
