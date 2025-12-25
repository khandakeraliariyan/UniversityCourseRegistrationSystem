package factory;

import registration.*;

public class CourseFactory {

    public static CourseRegistration createCourse(String type) {

        if (type.equalsIgnoreCase("theory")) {
            return new TheoryCourse();
        } 
        else if (type.equalsIgnoreCase("lab")) {
            return new LabCourse();
        } 
        else if (type.equalsIgnoreCase("online")) {
            return new OnlineCourse();
        }

        throw new IllegalArgumentException("Invalid course type");
    }
}
