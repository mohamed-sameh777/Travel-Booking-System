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

    /* Responsibilities */

    public boolean checkCarDetails() {
        return availability;
    }

    public boolean reserveCar() {
        if (availability) {
            availability = false;
            return true;
        }
        return false;
    }

    public double payCarFees(int days) {
        return pricePerDay * days;
    }

    /* Getters */

    public int getCarID() {
        return carID;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }
}
