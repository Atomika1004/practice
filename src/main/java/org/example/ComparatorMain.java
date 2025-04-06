package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.comparators.StudentComparator;
import org.example.comparators.UniversityComparator;
import org.example.enums.StudentComparators;
import org.example.enums.UniversityComparators;
import org.example.exceptions.ComparatorNotFountException;
import org.example.model.AllInfoObject;
import org.example.model.Statistics;
import org.example.model.Student;
import org.example.model.University;
import org.example.utils.ComparatorUtil;
import org.example.utils.StatisticUtil;
import org.example.IO.xlsx.ReaderXLSX;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static org.example.IO.JsonWriter.toJsonFile;
import static org.example.IO.XmlWriter.xmlMarshaling;

@Slf4j
public class ComparatorMain {

    private static Logger LOGGER;
    private static final Logger logger = Logger.getLogger(ComparatorMain.class.getName());
//    static {
//        System.setProperty("java.util.logging.config.file",
//                "/Users/atomika/Documents/java/module_gradle/practise/src/main/resources/logging.properties");
//        //must initialize loggers after setting above property
//        LOGGER = Logger.getLogger(ComparatorMain.class.getName());
//    }

    public static void main(String[] args) throws ComparatorNotFountException, IOException {
        try {
            LogManager.getLogManager().readConfiguration(
                    ComparatorMain.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
        List<University> universities = ReaderXLSX.getUniversitytList();
        UniversityComparator universityComparator = ComparatorUtil.getUniversityComparator(UniversityComparators.ID);
        if (universityComparator != null) {
            universities.stream()
                    .sorted(universityComparator)
                    .forEach(System.out::println);
        } else {
            log.error("Компаратор с таким параметром не найден");
            throw new ComparatorNotFountException("Компаратор с таким параметром не найден");
        }

        List<Student> students = ReaderXLSX.getStudentList();
        StudentComparator studentComparator = ComparatorUtil.getStudentComparator(StudentComparators.CURRENT_COURSE_NUMBER);
        if (studentComparator != null) {
            students.stream()
                    .sorted(studentComparator)
                    .forEach(System.out::println);
        } else {
            log.error("Компаратор с таким параметром не найден");
           throw new ComparatorNotFountException("Компаратор с таким параметром не найден");
        }
        List<Statistics> statisticsList = StatisticUtil.parseStudents(students,universities);
        statisticsList.forEach(System.out::println);
        logger.info(statisticsList.toString());

        AllInfoObject allInfoObject = new AllInfoObject();
        allInfoObject.setStudents(students);
        allInfoObject.setUniversities(universities);
        allInfoObject.setStatistics(statisticsList);
        allInfoObject.setProcessDate(new Date());

        xmlMarshaling(allInfoObject);
        toJsonFile(allInfoObject);
    }
}
