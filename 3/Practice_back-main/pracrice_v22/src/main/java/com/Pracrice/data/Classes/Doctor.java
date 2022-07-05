package com.Pracrice.data.Classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.print.Doc;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "doctor")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Doctor {
    @Id
    @Column(name = "iddoctor", nullable = false)
    private Integer id;

    @Column(name = "Name", nullable = false, length = 45)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DepartmentID", nullable = false)
    private Department departmentID;
    @ManyToMany
    @JoinTable(name = "doctor_has_patient",
            joinColumns = @JoinColumn(name = "doctorID"),
            inverseJoinColumns = @JoinColumn(name = "patientID"))
    private Set<Patient> patients = new LinkedHashSet<>();




    public Doctor(int doctorID){
        this.setId(doctorID);
    }
    public Doctor(){}
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

    public Department getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Department departmentID) {
        this.departmentID = departmentID;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    public void addPatient(Patient patient){ this.patients.add(patient); }

}