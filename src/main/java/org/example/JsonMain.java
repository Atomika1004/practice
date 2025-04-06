package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.model.Student;
import org.example.model.University;
import org.example.utils.JsonUtil;
import org.example.IO.xlsx.ReaderXLSX;

import java.util.List;

@Slf4j
public class JsonMain {
    public static void main(String[] args) {
        //блок с студентами
        List<Student> students = ReaderXLSX.getStudentList();
        String jsonListStudents = JsonUtil.toJson(students);
        log.info("jsonListStudents: {}", jsonListStudents);

        //блок с универами
        List<University> universities = ReaderXLSX.getUniversitytList();
        String jsonListUniversities = JsonUtil.toJson(universities);
        log.info("jsonListUniversities: {}", jsonListUniversities);

//        //десериализация для студентов с проверкой на кол-во
//        List<Student> convertJsonToListStudents = JsonUtil.jsonToListStudents(jsonListStudents);
//        if (students.size() == convertJsonToListStudents.size()) {
//            log.info("Размер изначальной коллекции студентов {}. " +
//                    "'\n Размер коллекции студентов после преобразования {}",
//                    students.size(), convertJsonToListStudents.size());
//        } else {
//            log.error("Размер изначальной коллекции студентов {}. \n" +
//                            "Размер коллекции студентов после преобразования {}",
//                            students.size(), convertJsonToListStudents.size());
//        }
//
//        //десериализация для универов с проверкой на кол-во
//        List<University> convertJsonToListUniversities = JsonUtil.jsonToListUniversities(jsonListUniversities);
//        if (universities.size() == convertJsonToListUniversities.size()) {
//            log.info("Размер изначальной коллекции университетов {}. " +
//                            "'\n Размер коллекции университетов после преобразования {}",
//                    universities.size(), convertJsonToListUniversities.size());
//        } else {
//            log.error("Размер изначальной коллекции университетов {}. \n" +
//                            "Размер коллекции университетов после преобразования {}",
//                    universities.size(), convertJsonToListUniversities.size());
//        }
//
//        //блок со стримом для студентов
//        students.forEach(student -> {
//            String convertToJson = JsonUtil.studentToJson(student);
//            log.info(convertToJson);
//            Student convertToStudent = JsonUtil.jsonToStudent(convertToJson);
//            log.info(convertToStudent.toString());
//        });
//
//        //блок со стримом для универов
//        universities.forEach(university -> {
//            String convertToJson = JsonUtil.universityToJson(university);
//            log.info(convertToJson);
//            University convertToUniversity = JsonUtil.jsonToUniversity(convertToJson);
//            log.info(convertToUniversity.toString());
//        });

    }
}
