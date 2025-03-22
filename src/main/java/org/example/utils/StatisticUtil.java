package org.example.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.example.enums.StudyProfile;
import org.example.model.Statistics;
import org.example.model.Student;
import org.example.model.University;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class StatisticUtil {

    public static List<Statistics> parseStudents(List<Student> students, List<University> universities) {
        List<Statistics> statisticsList = new ArrayList<>();
        Set<StudyProfile> profiles = universities.stream()
                .map(University::getStudyProfile).collect(Collectors.toSet());


        profiles.forEach(profile -> {
            Statistics st = new Statistics();
            statisticsList.add(st);
            st.setStudyProfile(profile);

            List<String> idsUniver = universities.stream()
                    .filter(university -> university.getStudyProfile().equals(profile))
                    .map(University::getId).toList();
            st.setCountUniversitiesByProfile(idsUniver.size());

            int countStudents = (int) students.stream()
                    .filter(student -> idsUniver.contains(student.getUniversityId())).count();
            st.setCountStudentsByProfile(countStudents);
            st.setUniversitiesName(StringUtils.EMPTY);
            String namesUniversity = universities.stream()
                    .map(University::getFullName)
                    .filter(idsUniver::contains).toList().toString();
            st.setUniversitiesName(namesUniversity);

            OptionalDouble avgScore = students.stream()
                    .filter(student -> idsUniver.contains(student.getUniversityId()))
                    .mapToDouble(Student::getAvgExamScore).average();

            avgScore.ifPresent(value -> st.setAverageExamScore(
                    (float) BigDecimal.valueOf(value)
                            .setScale(2, RoundingMode.HALF_UP)
                            .doubleValue()));
        });


        return statisticsList;
    }
}
