package org.example.model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import org.example.enums.StudyProfile;

import javax.xml.bind.annotation.*;

@Builder
@Data
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class University {

    @SerializedName("Id")
    @NonNull
    @XmlElement(name = "universityId")
    private String id;

    @SerializedName("Название")
    @NonNull
    @XmlElement(name = "universityName")
    private String fullName;

    @SerializedName("Сокращенное название")
    @NonNull
    @XmlTransient
    private String shortname;

    @SerializedName("Год постройки")
    @NonNull
    @XmlTransient
    private float yearOfFound;

    @SerializedName("Профиль обучения")
    @NonNull
    @XmlElement(name = "universityProfile")
    private StudyProfile studyProfile;

}
