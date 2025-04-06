package org.example.model;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import javax.xml.bind.annotation.*;

@Builder
@Data
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

    @SerializedName("ФИО")
    @NonNull
    @XmlElement(name = "studentName")
    private String fullName;

    @SerializedName("Id университета")
    @NonNull
    @XmlElement(name = "universityId")
    private String universityId;

    @SerializedName("Текущий курс")
    @NonNull
    @XmlTransient
    private float currentCourseNumber;

    @SerializedName("Средний рейтинг")
    @NonNull
    @XmlElement(name = "avgScore")
    private float avgExamScore;

}
