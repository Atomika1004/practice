package org.example.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Student {
    private String fullName;
    private String universityId;
    private float currentCourseNumber;
    private float avgExamScore;

    @Override
    public String toString() {
        return "Student{" +
                "fillName='" + fullName + '\'' +
                ", universityId='" + universityId + '\'' +
                ", currentCourseNumber=" + currentCourseNumber +
                ", avgExamScore=" + avgExamScore +
                '}';
    }
}
