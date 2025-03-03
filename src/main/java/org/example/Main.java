package org.example;

import org.example.enums.StudyProfile;
import org.example.model.Student;
import org.example.model.University;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class Main {
    private final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Start");
        logger.info("End");
    }

    public static void printInfo() {
        University mgy = University.builder()
                .id("1")
                .fullName("Московский государственный университет имени М.В. Ломоносова")
                .shortname("МГУ")
                .studyProfile(StudyProfile.ECONOMY)
                .yearOfFound(1755)
                .build();

        University mfti = University.builder()
                .id("2")
                .fullName("Московский физико-технический институт")
                .shortname("МФТИ")
                .studyProfile(StudyProfile.IT)
                .yearOfFound(1724)
                .build();

        University mgmy = University.builder()
                .id("3")
                .fullName("Московский государственный медицинский университет имени И. М. Сеченова")
                .shortname("МГМУ")
                .studyProfile(StudyProfile.MEDICINE)
                .yearOfFound(1789)
                .build();

        Student student = Student.builder()
                .fullName("Иван Иванов Ивановоч")
                .universityId("1")
                .currentCourseNumber(2)
                .avgExamScore(4.55F)
                .build();
        Student student1 = Student.builder()
                .fullName("Алексей Чиков Александрович")
                .universityId("2")
                .currentCourseNumber(4)
                .avgExamScore(4.89F)
                .build();
        Student student2 = Student.builder()
                .fullName("Елена Петрова Борисовна")
                .universityId("3")
                .currentCourseNumber(1)
                .avgExamScore(4.21F)
                .build();

        List<University> universities = List.of(mgy, mfti, mgmy);
        List<Student> students = List.of(student, student1, student2);

        System.out.println("Университеты: " + universities + '\n' + "Студенты: " + students);
    }

    public static boolean get() {
        return Thread.currentThread().getStackTrace().length > 0;
    }

}