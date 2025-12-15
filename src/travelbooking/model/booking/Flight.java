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

    /* Responsibilities */

    public boolean checkFlightDetails() {
        return seatsAvailable > 0;
    }

    public boolean reserveFlight() {
        if (seatsAvailable > 0) {
            seatsAvailable--;
            return true;
        }
        return false;
    }

    public void trackFlight() {
        System.out.println("Tracking flight " + flightNumber + " with " + airline);
    }

    public void manageSeatsAvailable(int seats) {
        this.seatsAvailable = seats;
    }

    public double payTicketFees() {
        return ticketPrice;
    }

    public void printTicket() {
        System.out.println("Ticket printed for flight " + flightNumber);
    }

    /* Getters */

    public double getTicketPrice() {
        return ticketPrice;
    }

    public String getFlightNumber() {
        return flightNumber;
    }
}
