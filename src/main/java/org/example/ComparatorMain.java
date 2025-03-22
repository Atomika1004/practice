package org.example;

import org.example.comparators.StudentComparator;
import org.example.comparators.UniversityComparator;
import org.example.enums.StudentComparators;
import org.example.enums.UniversityComparators;
import org.example.exceptions.ComparatorNotFountException;
import org.example.model.Statistics;
import org.example.model.Student;
import org.example.model.University;
import org.example.utils.ComparatorUtil;
import org.example.utils.StatisticUtil;
import org.example.xlsx.ReaderXLSX;
import org.example.xlsx.XlsWriter;

import java.io.IOException;
import java.util.List;

public class ComparatorMain {

    public static void main(String[] args) throws ComparatorNotFountException, IOException {
        List<University> universities = ReaderXLSX.getUniversitytList();
        UniversityComparator universityComparator = ComparatorUtil.getUniversityComparator(UniversityComparators.ID);
        if (universityComparator != null) {
            universities.stream()
                    .sorted(universityComparator)
                    .forEach(System.out::println);
        } else {
            throw new ComparatorNotFountException("Компаратор с таким параметром не найден");
        }

        List<Student> students = ReaderXLSX.getStudentList();
        StudentComparator studentComparator = ComparatorUtil.getStudentComparator(StudentComparators.CURRENT_COURSE_NUMBER);
        if (studentComparator != null) {
            students.stream()
                    .sorted(studentComparator)
                    .forEach(System.out::println);
        } else {
           throw new ComparatorNotFountException("Компаратор с таким параметром не найден");
        }
        List<Statistics> statisticsList = StatisticUtil.parseStudents(students,universities);
        statisticsList.forEach(System.out::println);
        //XlsWriter.writeXlsStatistics(statisticsList, "src/main/resources/universityInfo.xlsx");

    }
}
