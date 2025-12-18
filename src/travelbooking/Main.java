package travelbooking;

import api.dummyData;
import travelbooking.model.booking.Car;
import travelbooking.model.booking.Flight;
import travelbooking.model.booking.Hotel;
import travelbooking.model.booking.Reservation;
import travelbooking.model.payment.Payment;
import travelbooking.model.users.Admin;
import travelbooking.model.users.Customer;
import travelbooking.model.users.User;

import java.time.LocalDate;

public class Main{
        public static void main(String[] args) {
            System.out.println("=== TRAVEL BOOKING SYSTEM TEST ===\n");

            // 1. Test Users
            System.out.println("1. USER MANAGEMENT TESTS");
            System.out.println("=".repeat(30));
            testUsers();
            System.out.println();

            // 2. Test Cars
            System.out.println("2. CAR RENTAL TESTS");
            System.out.println("=".repeat(30));
            testCars();
            System.out.println();

            // 3. Test Flights
            System.out.println("3. FLIGHT BOOKING TESTS");
            System.out.println("=".repeat(30));
            testFlights();
            System.out.println();

            // 4. Test Hotels
            System.out.println("4. HOTEL BOOKING TESTS");
            System.out.println("=".repeat(30));
            testHotels();
            System.out.println();

            // 5. Test Reservations
            System.out.println("5. RESERVATION TESTS");
            System.out.println("=".repeat(30));
            testReservations();
            System.out.println();

            // 6. Test Payments
            System.out.println("6. PAYMENT TESTS");
            System.out.println("=".repeat(30));
            testPayments();
            System.out.println();

            // 7. Test Admin Functions
            System.out.println("7. ADMIN FUNCTION TESTS");
            System.out.println("=".repeat(30));
            testAdminFunctions();
            System.out.println();

            // 8. Test Customer Functions
            System.out.println("8. CUSTOMER FUNCTION TESTS");
            System.out.println("=".repeat(30));
            testCustomerFunctions();
            System.out.println();

            // 9. Test Integration
            System.out.println("9. INTEGRATION TEST - FULL BOOKING SCENARIO");
            System.out.println("=".repeat(30));
            testFullBookingScenario();
            System.out.println();

            System.out.println("=== ALL TESTS COMPLETED ===");
        }

        private static void testUsers() {
            // Create users
            User admin = new Admin(1, "Admin John", "admin@travel.com", "admin123");
            User customer = new Customer(2, "Alice Smith", "alice@email.com", "password123");

            // Test login
            System.out.println("Admin login test:");
            System.out.println("Login successful: " + admin.login("admin@travel.com", "admin123"));
            System.out.println("Login failed (wrong password): " + admin.login("admin@travel.com", "wrong"));

            System.out.println("\nView profiles:");
            admin.viewProfile();
            System.out.println();
            customer.viewProfile();

            // Test logout
            admin.logout();
        }

        private static void testCars() {
            System.out.println("Available cars from dummy data:");
            int availableCount = 0;
            for (Car car : dummyData.CARS) {
                car.checkCarDetails();
                if (car.seeAvailableCars()) {
                    availableCount++;
                }
            }
            System.out.println("\nTotal cars: " + dummyData.CARS.size());
            System.out.println("Available cars: " + availableCount);

            // Test car reservation
            Car firstAvailableCar = null;
            for (Car car : dummyData.CARS) {
                if (car.seeAvailableCars()) {
                    firstAvailableCar = car;
                    break;
                }
            }

            if (firstAvailableCar != null) {
                System.out.println("\nTesting car reservation for Car ID: " + firstAvailableCar.getCarID());
                System.out.println("Before reservation - Available: " + firstAvailableCar.seeAvailableCars());
                boolean reserved = firstAvailableCar.reserveCar();
                System.out.println("Reservation successful: " + reserved);
                System.out.println("After reservation - Available: " + firstAvailableCar.seeAvailableCars());
            }
        }

        private static void testFlights() {
            System.out.println("Available flights from dummy data:");
            int availableCount = 0;
            for (Flight flight : dummyData.FLIGHTS) {
                flight.checkFlightDetails();
                if (flight.seeAvailableFlights()) {
                    availableCount++;
                }
            }
            System.out.println("\nTotal flights: " + dummyData.FLIGHTS.size());
            System.out.println("Available flights: " + availableCount);

            // Test flight reservation
            if (!dummyData.FLIGHTS.isEmpty()) {
                Flight flight = dummyData.FLIGHTS.get(0);
                System.out.println("\nTesting flight reservation for: " + flight.getFlightNumber());
                System.out.println("Before reservation - Seats available: " + flight.seeAvailableFlights());
                boolean reserved = flight.reserveFlight();
                System.out.println("Reservation successful: " + reserved);
                flight.trackFlight();
                flight.printTicket();
            }
        }

        private static void testHotels() {
            System.out.println("Available hotels from dummy data:");
            for (Hotel hotel : dummyData.HOTELS) {
                hotel.showHotels();
                System.out.println("---");
            }

            System.out.println("\nTotal hotels: " + dummyData.HOTELS.size());

            // Test hotel reservation
            if (!dummyData.HOTELS.isEmpty()) {
                Hotel hotel = dummyData.HOTELS.get(0);
                System.out.println("\nTesting hotel reservation for: " + hotel.getName());
                System.out.println("Available rooms before: " + hotel.seeAvailableRooms());
                boolean reserved = hotel.makeReservation();
                System.out.println("Reservation successful: " + reserved);
                System.out.println("Available rooms after: " + hotel.seeAvailableRooms());
                System.out.println("Room types: " + hotel.seeRoomTypes());
            }
        }

        private static void testReservations() {
            System.out.println("Testing reservation system:");

            // Create a reservation
            Reservation reservation = new Reservation();

            // Set dates
            LocalDate startDate = LocalDate.now();
            LocalDate endDate = startDate.plusDays(5);
            reservation.setReservationDates(startDate, endDate);

            // Attach a flight
            if (!dummyData.FLIGHTS.isEmpty()) {
                reservation.attachFlight(dummyData.FLIGHTS.get(0));
            }

            // Attach a car
            if (!dummyData.CARS.isEmpty()) {
                reservation.attachCarRental(dummyData.CARS.get(1));
            }

            // Calculate fees
            double fees = reservation.calculateReservationFees(5);
            System.out.println("Calculated reservation fees: $" + fees);

            // Show reservation details
            reservation.showReservationDetails();
        }

        private static void testPayments() {
            System.out.println("Testing payment system:");

            // Create a payment
            Payment payment = new Payment(1001, 5000.0, "Credit Card");

            // Show initial details
            payment.showPaymentDetails();

            // Make payment with sufficient amount
            boolean success1 = payment.makePayment(4500.0);
            System.out.println("Payment of $4500 successful: " + success1);
            payment.showPaymentDetails();

            // Create another payment for insufficient amount
            Payment payment2 = new Payment(1002, 3000.0, "Cash");
            boolean success2 = payment2.makePayment(3500.0);
            System.out.println("\nPayment of $3500 with $3000 cash successful: " + success2);
            payment2.showPaymentDetails();
        }

        private static void testAdminFunctions() {
            System.out.println("Testing admin functions:");

            Admin admin = new Admin(1, "System Admin", "sysadmin@travel.com", "adminpass");

            // Test admin capabilities
            admin.addCar();
            admin.addFlight();
            admin.addHotel();
            admin.viewAllUsers();
            admin.removeBooking(123);
        }

        private static void testCustomerFunctions() {
            System.out.println("Testing customer functions:");

            Customer customer = new Customer(101, "John Doe", "john@email.com", "password");

            // Test customer capabilities
            customer.searchCars();
            customer.viewBookings();
            customer.cancelBooking(456);

            // Test booking a car
            Car availableCar = null;
            for (Car car : dummyData.CARS) {
                if (car.seeAvailableCars()) {
                    availableCar = car;
                    break;
                }
            }

            if (availableCar != null) {
                System.out.println("\nBooking car: " + availableCar.getCarID());
                boolean booked = customer.bookCar(availableCar, 3);
                System.out.println("Car booking result: " + booked);
            }
        }

        private static void testFullBookingScenario() {
            System.out.println("Testing full booking scenario:");

            // 1. Customer logs in
            Customer customer = new Customer(200, "Traveler Bob", "bob@email.com", "travel123");
            System.out.println("1. Customer login: " + customer.login("bob@email.com", "travel123"));

            // 2. Search for a flight
            System.out.println("\n2. Searching for available flights:");
            Flight selectedFlight = dummyData.FLIGHTS.get(2);
            selectedFlight.checkFlightDetails();

            // 3. Reserve flight
            System.out.println("\n3. Reserving flight:");
            boolean flightReserved = selectedFlight.reserveFlight();
            System.out.println("Flight reserved: " + flightReserved);

            // 4. Search for a car
            System.out.println("\n4. Searching for available cars:");
            Car selectedCar = dummyData.CARS.get(3);
            selectedCar.checkCarDetails();

            // 5. Book car
            System.out.println("\n5. Booking car:");
            boolean carBooked = customer.bookCar(selectedCar, 4);
            System.out.println("Car booked: " + carBooked);

            // 6. Create reservation
            System.out.println("\n6. Creating reservation:");
            Reservation reservation = new Reservation();
            reservation.attachFlight(selectedFlight);
            reservation.attachCarRental(selectedCar);
            reservation.setReservationDates(LocalDate.now(), LocalDate.now().plusDays(4));
            double totalFees = reservation.calculateReservationFees(4);
            System.out.println("Total fees calculated: $" + totalFees);
            reservation.showReservationDetails();

            // 7. Make payment
            System.out.println("\n7. Processing payment:");
            Payment payment = new Payment(3001, totalFees + 100, "Credit Card");
            boolean paymentSuccess = payment.makePayment(totalFees);
            System.out.println("Payment successful: " + paymentSuccess);
            payment.showPaymentDetails();

            // 8. View profile
            System.out.println("\n8. Customer profile:");
            customer.viewProfile();

            // 9. Logout
            System.out.println("\n9. Logging out:");
            customer.logout();

            System.out.println("\n=== Booking scenario completed successfully ===");
        }
}