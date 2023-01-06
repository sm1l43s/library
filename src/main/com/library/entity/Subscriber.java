package main.com.library.entity;

public class Subscriber {
    private int id;
    private String name;
    private Subscription subscription;

    public Subscriber(String name, Subscription subscription) {
        this.name = name;
        this.subscription = subscription;
    }

    public Subscriber(int id, String name, Subscription subscription) {
        this.id = id;
        this.name = name;
        this.subscription = subscription;
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

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subscription=" + subscription +
                '}';
    }
}
