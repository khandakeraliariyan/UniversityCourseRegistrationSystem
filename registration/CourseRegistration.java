package registration;

import payment.PaymentStrategy;

public abstract class CourseRegistration {

    protected PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // TEMPLATE METHOD
    public final void registerCourse() {
        selectCourse();
        double totalFee = calculateFee();
        processPayment(totalFee);
        confirmRegistration();
    }

    protected abstract void selectCourse();
    protected abstract double calculateFee();

    private void processPayment(double amount) {
        paymentStrategy.pay(amount);
    }

    protected void confirmRegistration() {
        System.out.println("Course registration completed successfully.");
    }
}
