package org.example.utils;

import lombok.extern.slf4j.Slf4j;
import org.example.comparators.*;
import org.example.comparators.student.StudentAvgExamScoreComparator;
import org.example.comparators.student.StudentCurrentCourseNumberComparator;
import org.example.comparators.student.StudentFullNameComparator;
import org.example.comparators.student.StudentUniversityIdComparator;
import org.example.comparators.university.*;
import org.example.enums.StudentComparators;
import org.example.enums.UniversityComparators;

@Slf4j
public class ComparatorUtil {

    ComparatorUtil() {
    }

    public static StudentComparator getStudentComparator(StudentComparators comparator) {
        switch (comparator) {
            case FULL_NAME -> {
                return new StudentFullNameComparator();
            }
            case UNIVERSITY_ID -> {
                return new StudentUniversityIdComparator();
            }
            case CURRENT_COURSE_NUMBER -> {
                return new StudentCurrentCourseNumberComparator();
            }
            case AVG_EXAM_SCORE -> {
                return new StudentAvgExamScoreComparator();
            }
            default -> {
                return null;
            }
        }
    }

    public static UniversityComparator getUniversityComparator(UniversityComparators comparator) {
        log.info("Сортировка по полю {}",comparator.toString());
        switch (comparator) {
            case ID -> {
                return new UniversityIdComparator();
            }
            case FULL_NAME -> {
                return new UniversityFullNameComparator();
            }
            case SHORT_NAME -> {
                return new UniversityShortNameComparator();
            }
            case YEAR_OF_FOUND -> {
                return new UniversityYearsOfFoundComparator();
            }
            case STUDY_PROFILE -> {
                return new UniversityStudyProfileComparator();
            }
            default -> {
                return null;
            }
        }
    }
}
