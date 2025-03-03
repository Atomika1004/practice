package org.example.utils;

import org.example.comparators.*;
import org.example.enums.StudentComparators;
import org.example.enums.UniversityComparators;

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
