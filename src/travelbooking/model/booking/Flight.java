package model.booking;

public class Flight {

    private String flightNumber;
    private String airline;
    private String departure;
    private String arrival;
    private int seatsAvailable;
    private double ticketPrice;

    public Flight(String flightNumber, String airline, String departure,
                  String arrival, int seatsAvailable, double ticketPrice) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.departure = departure;
        this.arrival = arrival;
        this.seatsAvailable = seatsAvailable;
        this.ticketPrice = ticketPrice;
    }

    // === Core Responsibilities ===

    public boolean seeAvailableFlights() {
        return seatsAvailable > 0;
    }

    public void checkFlightDetails() {
        System.out.println("Flight " + flightNumber + " | Airline: " + airline +
                " | From: " + departure + " | To: " + arrival +
                " | Price: " + ticketPrice);
    }

    public boolean reserveFlight() {
        if (seatsAvailable > 0) {
            seatsAvailable--;
            return true;
        }
        return false;
    }

    public void manageSeatsAvailable(int seats) {
        this.seatsAvailable = seats;
    }

    public void trackFlight() {
        System.out.println("Tracking flight " + flightNumber);
    }

    public boolean payTicketFees(double amount) {
        return amount >= ticketPrice;
    }

    public void printTicket() {
        System.out.println("Ticket printed for flight " + flightNumber);
    }

    // === Getters ===

    public double getTicketPrice() {
        return ticketPrice;
    }

    public String getFlightNumber() {
        return flightNumber;
    }
}
