package com.example.demorest.Bean;

import jakarta.persistence.*;

@Entity
@Table(name = "organization")
public class organisations {

    @Id
    @Column(name="id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  // maps to "organisation" field of placement and to "organisation" field of Alumni_organisation.

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="address")
    private String address;

    public organisations() {
    }

    public organisations(Integer id,String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
