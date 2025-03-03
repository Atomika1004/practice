package org.example.comparators;

import org.example.model.Student;

public class StudentCurrentCourseNumberComparator implements StudentComparator{

    @Override
    public int compare(Student o1, Student o2) {
        return Float.compare(o1.getCurrentCourseNumber(), o2.getCurrentCourseNumber());
    }
}
