package com.example.demorest.DAO;

import com.example.demorest.Bean.alumni_organisation;
import com.example.demorest.Bean.employee;
import com.example.demorest.Bean.organisations;

import java.util.List;

public interface almorgDAO {

    void addAlumni(alumni_organisation ao);

    List<Object[]> getAlumni(organisations org);
}
