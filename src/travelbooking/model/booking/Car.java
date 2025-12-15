package model.booking;


public class Car {

    private String id;
    private String model;
    private double price;
    private boolean available;

    public Car(String id, String model, double price) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.available = true;
    }

    public boolean checkAvailability() {
        return available;
    }

    public void reserveCar() {
        available = false;
    }

    public double getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }
}
