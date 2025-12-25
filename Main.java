import factory.CourseFactory;
import payment.PayPalPayment;
import registration.CourseRegistration;

public class Main {

    public static void main(String[] args) {

        CourseRegistration course = CourseFactory.createCourse("lab");

        course.setPaymentStrategy(new PayPalPayment());

        course.registerCourse();
    }
}
