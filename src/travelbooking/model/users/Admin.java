package travelbooking.model.users;

public class Admin extends User {

    public Admin(int userID, String name, String email, String password) {
        super(userID, name, email, password, "Admin");
    }

    // === Admin Responsibilities ===

    public void addCar() {
        System.out.println("Car added to the system.");
    }

    public void addFlight() {
        System.out.println("Flight added to the system.");
    }

    public void addHotel() {
        System.out.println("Hotel added to the system.");
    }

    public void removeBooking(int bookingID) {
        System.out.println("Booking " + bookingID + " removed.");
    }

    public void viewAllUsers() {
        System.out.println("Viewing all registered users.");
    }
}