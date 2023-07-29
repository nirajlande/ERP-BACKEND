package com.example.demorest.Util;

import com.example.demorest.Bean.*;
import com.example.demorest.DAO.*;
import com.example.demorest.DAO.DAOImplementation.*;
import java.sql.Date;
import java.time.LocalDate;


public class AddingData {
    public void add()
    {
        employeeDAO employeeService = new employeeDAOimpl();
        //employee emp = new employee(6, "emp6", "emp7", "emp7@iiitb.org", "HOD", "Maintenance");
        //employeeService.addEmployee(emp);

        employee emp = new employee(1, "emp1", "emp1", "emp1@iiitb.org", "Professor", "outreach");
        employeeService.addEmployee(emp);
        employee emp1 = new employee(2, "emp2", "emp2", "emp2@iiitb.org", "HOD", "outreach");
        employeeService.addEmployee(emp1);
        employee emp2 = new employee(3, "emp3", "emp3", "emp3@iiitb.org", "professor", "Maintenance");
        employeeService.addEmployee(emp2);

        orgDAO orgService = new orgDAOimpl();

        organisations o1 = new organisations(1, "Microsoft", "Bangalore");
        orgService.addOrg(o1);
        organisations o2 = new organisations(2, "Flipkart", "Noida");
        orgService.addOrg(o2);
        organisations o3 = new organisations(3, "Amazon", "Delhi");
        orgService.addOrg(o3);
        organisations o4 = new organisations(4, "HP", "Hyderabad");
        orgService.addOrg(o4);


        almorgDAO alorgService = new almorgDAOimpl();

        alumni_organisation ao1 = new alumni_organisation(1, o1, "alumni1", "al1@xyz.com", "sde2", "2013-12-08", "2015-12-12");
        alorgService.addAlumni(ao1);
        alumni_organisation ao2 = new alumni_organisation(2, o1, "alumni2", "al2@xyz.com", "research engg", "2012-12-08","2014-12-12");
        alorgService.addAlumni(ao2);
        alumni_organisation ao3 = new alumni_organisation(3, o3, "alumni3", "al3@xyz.com", "sde3","2018-12-08", "2023-12-12");
        alorgService.addAlumni(ao3);
        alumni_organisation ao4 = new alumni_organisation(4, o4, "alumni4", "al4@xyz.com", "manager","2022-08-08", "2024-03-20");
        alorgService.addAlumni(ao4);
        alumni_organisation ao5 = new alumni_organisation(5, o2, "alumni5", "al5@xyz.com", "manager","2021-01-12", "2024-03-20");
        alorgService.addAlumni(ao5);


        placementDAO placementService = new placementDAOimpl();
        placement p1 = new placement(1, o1, "sde", "software development engineer", 10, 2.8 );
        placementService.addPlacement(p1);
        placement p2 = new placement(2, o1, "CSA", "Computer System Analyst", 5, 3.2 );
        placementService.addPlacement(p2);
        placement p3 = new placement(3, o2, "se", "software engineer", 8, null );
        placementService.addPlacement(p3);
        placement p4 = new placement(4, o3, "RS", "Research Scientist", 2,  3.2);
        placementService.addPlacement(p4);
        placement p5 = new placement(5, o3, "CE", "Cloud Engnieer", 10, null );
        placementService.addPlacement(p5);
        placement p6 = new placement(6, o4, "DQE", "Data Quality Engineer", 10, 2.8 );
        placementService.addPlacement(p6);


        studentsDAO studentsService = new studentsDAOimpl();

        students s1 = new students(1, "MT2022001", "student1", "s1", "student1@iiitb.org", "AIML", 1);
        studentsService.addStudents(s1);
        students s2 = new students(2, "MT2022002", "student2", "s2", "student2@iiitb.org", "NC", 6);
        studentsService.addStudents(s2);
        students s3 = new students(3, "MT2022003", "student3", "s3", "student3@iiitb.org", "VLSI", 4);
        studentsService.addStudents(s3);
        students s4 = new students(4, "MT2022004", "student4", "s4", "student4@iiitb.org", "TSCD", null);
        studentsService.addStudents(s4);
        students s5 = new students(5, "MT2022005", "student5", "s5", "student5@iiitb.org", "AIML", 8);
        studentsService.addStudents(s5);

        placStudDAO placStudService = new placStudDAOimpl();
        //public placement_student(Integer id, placement placement_id, students student_id,  String acceptance, String comments,  date) {
        placement_student ps1 = new placement_student(1, p1, s1 , "ACCEPT",  "02-11-2022");
        placStudService.addPlacStud(ps1);
        placement_student ps2 = new placement_student(2, p1, s2 , "REJECT", "02-11-2022");
        placStudService.addPlacStud(ps2);
        placement_student ps3 = new placement_student(3, p1, s3 , "REJECT",  "02-11-2022");
        placStudService.addPlacStud(ps3);
        placement_student ps4 = new placement_student(4, p2, s3 , "ACCEPT",  "02-11-2022");
        placStudService.addPlacStud(ps4);
        placement_student ps5 = new placement_student(5, p3, s4 , "PENDING",  "02-11-2022");
        placStudService.addPlacStud(ps5);
        placement_student ps6 = new placement_student(6, p4, s2 , "ACCEPT",  "02-11-2022");
        placStudService.addPlacStud(ps6);
        placement_student ps7 = new placement_student(7, p5, s5 , "REJECT",  "02-11-2022");
        placStudService.addPlacStud(ps7);
        placement_student ps8 = new placement_student(8, p6, s5 , "ACCEPT",  "02-11-2022");
        placStudService.addPlacStud(ps8);














    }
}