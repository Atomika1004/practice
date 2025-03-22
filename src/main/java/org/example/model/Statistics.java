package org.example.model;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import org.example.enums.StudyProfile;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@Builder
public class Statistics {

    @SerializedName("Профиль обучения")
    @NonNull
    private StudyProfile studyProfile;

    @SerializedName("Средняя оценка за экзамен")
    @NonNull
    private float averageExamScore;

    @SerializedName("Количество студентов по профилю")
    @NonNull
    private int countStudentsByProfile;

    @SerializedName("Количество университетов по профилю")
    @NonNull
    private int countUniversitiesByProfile;

    @SerializedName("Названия университетов")
    @NonNull
    private String universitiesName;
}
