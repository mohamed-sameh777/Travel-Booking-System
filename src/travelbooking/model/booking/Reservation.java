package model.booking;

import java.util.UUID;

public class Reservation {

    private String reservationCode;
    private String reservationDates;
    private double totalFees;
    private String selectedOption; // Flight or Car info

    public Reservation(String reservationDates, String selectedOption) {
        this.reservationDates = reservationDates;
        this.selectedOption = selectedOption;
        this.reservationCode = generateReservationCode();
    }

    /* Core Responsibilities */

    public void calculateReservationFees(double amount) {
        this.totalFees = amount;
    }

    private String generateReservationCode() {
        return "RES-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public void showReservationDetails() {
        System.out.println("Reservation Code: " + reservationCode);
        System.out.println("Dates: " + reservationDates);
        System.out.println("Selected Option: " + selectedOption);
        System.out.println("Total Fees: $" + totalFees);
    }

    /* Getters */

    public String getReservationCode() {
        return reservationCode;
    }

    public double getTotalFees() {
        return totalFees;
    }
}
