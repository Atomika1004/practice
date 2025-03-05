package org.example.model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Student {

    @SerializedName("ФИО")
    private String fullName;

    @SerializedName("Id университета")
    private String universityId;

    @SerializedName("Текущий курс")
    private float currentCourseNumber;

    @SerializedName("Средний рейтинг")
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
