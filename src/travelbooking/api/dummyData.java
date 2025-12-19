package api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import travelbooking.model.booking.Car;
import travelbooking.model.booking.Flight;
import travelbooking.model.booking.Hotel;


public class dummyData {

    // ===================== HOTELS =====================
    public static final List<Hotel> HOTELS = new ArrayList<>();

    // ===================== CARS =====================
    public static final List<Car> CARS = new ArrayList<>();

    // ===================== FLIGHTS =====================
    public static final List<Flight> FLIGHTS = new ArrayList<>();

    // Static initializer (runs once)
    static {

        // -------- Hotels --------
        HOTELS.add(new Hotel(1, "Grand Nile Hotel", "Cairo", 20,
                Arrays.asList("Single", "Double", "Suite")));

        HOTELS.add(new Hotel(2, "Sea View Resort", "Alexandria", 15,
                Arrays.asList("Double", "Suite")));

        HOTELS.add(new Hotel(3, "Desert Rose", "Hurghada", 30,
                Arrays.asList("Single", "Double")));

        HOTELS.add(new Hotel(4, "Mountain Lodge", "Sinai", 10,
                Arrays.asList("Single", "Suite")));

        HOTELS.add(new Hotel(5, "City Center Inn", "Giza", 25,
                Arrays.asList("Single", "Double")));

        HOTELS.add(new Hotel(6, "Royal Palace", "Luxor", 12,
                Arrays.asList("Double", "Suite")));

        HOTELS.add(new Hotel(7, "Sunset Hotel", "Aswan", 18,
                Arrays.asList("Single", "Double")));

        HOTELS.add(new Hotel(8, "Oasis Resort", "Siwa", 8,
                Arrays.asList("Suite")));

        HOTELS.add(new Hotel(9, "Blue Lagoon Hotel", "Dahab", 22,
                Arrays.asList("Single", "Double", "Suite")));

        HOTELS.add(new Hotel(10, "Skyline Hotel", "New Cairo", 35,
                Arrays.asList("Single", "Double", "Suite")));

        // -------- Cars --------
        CARS.add(new Car(1, "Sedan", "Toyota", true, 800));
        CARS.add(new Car(2, "SUV", "Hyundai", true, 1200));
        CARS.add(new Car(3, "Hatchback", "Kia", false, 600));
        CARS.add(new Car(4, "SUV", "Nissan", true, 1300));
        CARS.add(new Car(5, "Sedan", "BMW", false, 2000));
        CARS.add(new Car(6, "Coupe", "Mercedes", true, 2500));
        CARS.add(new Car(7, "Sedan", "Chevrolet", true, 900));
        CARS.add(new Car(8, "Van", "Toyota", true, 1500));
        CARS.add(new Car(9, "SUV", "Jeep", false, 1800));
        CARS.add(new Car(10, "Hatchback", "Ford", true, 700));

        // -------- Flights --------
        FLIGHTS.add(new Flight("MS101", "EgyptAir", "Cairo", "Dubai", 120, 3500));
        FLIGHTS.add(new Flight("EK202", "Emirates", "Dubai", "London", 200, 7200));
        FLIGHTS.add(new Flight("QR303", "Qatar Airways", "Doha", "Paris", 180, 6800));
        FLIGHTS.add(new Flight("TK404", "Turkish Airlines", "Istanbul", "Rome", 150, 5200));
        FLIGHTS.add(new Flight("LH505", "Lufthansa", "Frankfurt", "New York", 220, 9000));
        FLIGHTS.add(new Flight("AF606", "Air France", "Paris", "Cairo", 140, 6100));
        FLIGHTS.add(new Flight("BA707", "British Airways", "London", "Toronto", 210, 8800));
        FLIGHTS.add(new Flight("SV808", "Saudia", "Jeddah", "Riyadh", 160, 2400));
        FLIGHTS.add(new Flight("EY909", "Etihad", "Abu Dhabi", "Tokyo", 190, 11000));
        FLIGHTS.add(new Flight("AZ010", "ITA Airways", "Rome", "Madrid", 130, 4300));
    }

    // Prevent instantiation
    private dummyData() {
    }
}

