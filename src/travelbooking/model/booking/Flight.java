package model.booking;


public class Flight {

    private String id;
    private String destination;
    private double price;
    private int availableSeats;

    public Flight(String id, String destination, double price, int availableSeats) {
        this.id = id;
        this.destination = destination;
        this.price = price;
        this.availableSeats = availableSeats;
    }

    public boolean checkAvailability() {
        return availableSeats > 0;
    }

    public void updateAvailability() {
        if (availableSeats > 0) {
            availableSeats--;
        }
    }

    public double getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }
}
