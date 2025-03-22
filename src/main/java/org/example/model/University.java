package org.example.model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import org.example.enums.StudyProfile;

@Builder
@Data
@ToString
public class University {

    @SerializedName("Id")
    @NonNull
    private String id;

    @SerializedName("Название")
    @NonNull
    private String fullName;

    @SerializedName("Сокращенное название")
    @NonNull
    private String shortname;

    @SerializedName("Год постройки")
    @NonNull
    private float yearOfFound;

    @SerializedName("Профиль обучения")
    @NonNull
    private StudyProfile studyProfile;

}
