package model.payment;

public class Payment {

    private int paymentID;
    private double amount;
    private String paymentMethod;   // e.g. Cash, Card
    private boolean paymentStatus;  // true = paid, false = failed

    public Payment(int paymentID, double amount, String paymentMethod) {
        this.paymentID = paymentID;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = false;
    }

    // === Core Responsibilities ===

    public boolean makePayment(double requiredAmount) {
        if (amount >= requiredAmount) {
            paymentStatus = true;
            return true;
        }
        paymentStatus = false;
        return false;
    }

    public void showPaymentDetails() {
        System.out.println(
                "Payment ID: " + paymentID +
                        " | Method: " + paymentMethod +
                        " | Amount: " + amount +
                        " | Status: " + (paymentStatus ? "Paid" : "Failed")
        );
    }

    // === Getters ===

    public boolean isPaymentSuccessful() {
        return paymentStatus;
    }

    public double getAmount() {
        return amount;
    }
}