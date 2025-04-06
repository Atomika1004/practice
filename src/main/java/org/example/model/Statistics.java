package org.example.model;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import org.example.enums.StudyProfile;

import javax.xml.bind.annotation.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class Statistics {

    @SerializedName("Профиль обучения")
    @NonNull
    @XmlElement(name = "universityProfile")
    private StudyProfile studyProfile;

    @SerializedName("Средняя оценка за экзамен")
    @NonNull
    @XmlElement(name = "avgScore")
    private float averageExamScore;

    @SerializedName("Количество студентов по профилю")
    @NonNull
    @XmlTransient
    private int countStudentsByProfile;

    @SerializedName("Количество университетов по профилю")
    @NonNull
    @XmlTransient
    private int countUniversitiesByProfile;

    @SerializedName("Названия университетов")
    @NonNull
    @XmlTransient
    private String universitiesName;
}
