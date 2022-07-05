package com.Pracrice.data.Classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.print.Doc;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "department")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddepartment", nullable = false)
    private Integer id;

    @Column(name = "Name", nullable = false, length = 20)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HospitalID", nullable = false)
    private Hospital hospitalID;
    @JsonIgnore
    @OneToMany(mappedBy = "departmentID")
    private Set<Doctor> doctors = new LinkedHashSet<>();

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

    public Department(){}
    public Department(int dep){
        this.setId(dep);
    }
    public Hospital getHospitalID() {
        return hospitalID;
    }

    public void setHospitalID(Hospital hospitalID) {
        this.hospitalID = hospitalID;
    }

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void addDoctors(Doctor doctor){this.doctors.add(doctor);}

}