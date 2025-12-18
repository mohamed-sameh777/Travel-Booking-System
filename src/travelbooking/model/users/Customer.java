package model.users;

import model.booking.Car;

public class Customer extends User {

    public Customer(int userID, String name, String email, String password) {
        super(userID, name, email, password, "Customer");
    }

    // === Customer Responsibilities ===

    public void searchCars() {
        System.out.println("Searching available cars...");
    }

    public boolean bookCar(Car car, int days) {
        if (car.seeAvailableCars()) {
            car.reserveCar();
            System.out.println("Car booked for " + days + " days.");
            return true;
        }
        System.out.println("Car not available.");
        return false;
    }

    public void viewBookings() {
        System.out.println("Displaying customer bookings.");
    }

    public void cancelBooking(int bookingID) {
        System.out.println("Booking " + bookingID + " canceled.");
    }
}
