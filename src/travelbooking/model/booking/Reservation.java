package travelbooking.model.booking;

import java.time.LocalDate;
import java.util.UUID;

public class Reservation {

    private String reservationCode;
    private LocalDate startDate;
    private LocalDate endDate;
    private double reservationFees;

    private Flight flight;        // 0..1
    private Car carRental;  // 0..1

    public Reservation() {
        this.reservationCode = generateReservationCode();
    }

    // === Reservation Logic ===

    public void setReservationDates(LocalDate start, LocalDate end) {
        this.startDate = start;
        this.endDate = end;
    }

    public void attachFlight(Flight flight) {
        this.flight = flight;
    }

    public void attachCarRental(Car carRental) {
        this.carRental = carRental;
    }

    public double calculateReservationFees(int days) {
        if (flight != null) {
            reservationFees = flight.getTicketPrice();
        } else if (carRental != null) {
            reservationFees = carRental.getPricePerDay() * days;
        }
        return reservationFees;
    }

    private String generateReservationCode() {
        return "RES-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public void showReservationDetails() {
        System.out.println("Reservation Code: " + reservationCode);
        System.out.println("Fees: " + reservationFees);
    }

    // === Getters ===

    public String getReservationCode() {
        return reservationCode;
    }
}
