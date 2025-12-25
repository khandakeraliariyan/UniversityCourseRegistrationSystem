package registration;

import fee.*;

public class OnlineCourse extends CourseRegistration {

    @Override
    protected void selectCourse() {
        System.out.println("Online course selected.");
    }

    @Override
    protected double calculateFee() {
        Fee fee = new LateFeeDecorator(new BaseFee());
        return fee.getFee();
    }
}
