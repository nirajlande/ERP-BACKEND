package com.example.demorest.DAO;

import com.example.demorest.Bean.organisations;
import com.example.demorest.Bean.students;

import java.util.List;

public interface studentsDAO {
    boolean addStudents(students s);

    List<Object[]> getAll();
    List<Object[]> getPlaced_Students();
    List<Object[]> getSpecialisation(students st);

    List<Object[]> getStudentsByOrg(organisations org);

    List<Object[]> getStudentsByYear(String yr);

    List<Object[]> getStudentsByDomain(String dmn);
    List<Object[]> getNotPlaced_Students();
    //List<students> getAll();
}