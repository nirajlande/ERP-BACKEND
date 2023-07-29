package com.example.demorest.DAO;
import com.example.demorest.Bean.employee;

public interface employeeDAO {

    boolean emailVerify(employee emp);
    //boolean registerStudent(employee emp);
    boolean addEmployee(employee emp);

}