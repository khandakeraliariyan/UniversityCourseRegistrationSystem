package registration;

import fee.*;

public class LabCourse extends CourseRegistration {

    @Override
    protected void selectCourse() {
        System.out.println("Lab course selected.");
    }

    @Override
    protected double calculateFee() {
        Fee fee = new LabFeeDecorator(
                      new ExamFeeDecorator(
                          new BaseFee()));
        return fee.getFee();
    }
}
