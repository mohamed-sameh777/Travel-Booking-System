package model.booking;

public class Car {

    private int carID;
    private String carType;
    private String company;
    private boolean availability;
    private double pricePerDay;

    public Car(int carID, String carType, String company,
                     boolean availability, double pricePerDay) {
        this.carID = carID;
        this.carType = carType;
        this.company = company;
        this.availability = availability;
        this.pricePerDay = pricePerDay;
    }

    // === Core Responsibilities ===

    public boolean seeAvailableCars() {
        return availability;
    }

    public void seeCarTypes() {
        System.out.println("Car Type: " + carType);
    }

    public void checkCarDetails() {
        System.out.println("Car ID: " + carID + " | Type: " + carType +
                " | Company: " + company + " | Price/Day: " + pricePerDay);
    }

    public boolean reserveCar() {
        if (availability) {
            availability = false;
            return true;
        }
        return false;
    }

    public boolean payCarFees(double amount, int days) {
        return amount >= (pricePerDay * days);
    }

    // === Getters ===

    public double getPricePerDay() {
        return pricePerDay;
    }

    public int getCarID() {
        return carID;
    }
}
