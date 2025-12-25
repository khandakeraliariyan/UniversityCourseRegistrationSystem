package registration;

import fee.*;

public class TheoryCourse extends CourseRegistration {

    @Override
    protected void selectCourse() {
        System.out.println("Theory course selected.");
    }

    @Override
    protected double calculateFee() {
        Fee fee = new ExamFeeDecorator(new BaseFee());
        return fee.getFee();
    }
}
