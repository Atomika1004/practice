package org.example.model;

import lombok.Builder;
import lombok.Data;
import org.example.enums.StudyProfile;

@Builder
@Data
public class University {
    private String id;
    private String fullName;
    private String shortname;
    private int yearOfFound;
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
