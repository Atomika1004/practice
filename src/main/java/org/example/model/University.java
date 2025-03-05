package org.example.model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import org.example.enums.StudyProfile;

@Builder
@Data
public class University {

    @SerializedName("Id")
    private String id;

    @SerializedName("Название")
    private String fullName;

    @SerializedName("Сокращенное название")
    private String shortname;

    @SerializedName("Год постройки")
    private float yearOfFound;

    @SerializedName("Профиль обучения")
    private StudyProfile studyProfile;

    @Override
    public String toString() {
        return "University{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", shortname='" + shortname + '\'' +
                ", yearOfFound=" + yearOfFound +
                ", studyProfile=" + studyProfile +
                '}';
    }
}
