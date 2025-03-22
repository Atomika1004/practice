package org.example.model;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Builder
@Data
@ToString
public class Student {

    @SerializedName("ФИО")
    @NonNull
    private String fullName;

    @SerializedName("Id университета")
    @NonNull
    private String universityId;

    @SerializedName("Текущий курс")
    @NonNull
    private float currentCourseNumber;

    @SerializedName("Средний рейтинг")
    @NonNull
    private float avgExamScore;

}
