package payment;

public class NagadPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Nagad");
    }
}
