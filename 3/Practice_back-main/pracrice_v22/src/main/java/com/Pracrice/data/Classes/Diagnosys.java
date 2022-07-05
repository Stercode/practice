package com.Pracrice.data.Classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "diagnosys")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Diagnosys {
    @Id
    @Column(name = "iddiagnosys", nullable = false)
    private Integer id;

    @Column(name = "Diagnosys", nullable = false, length = 20)
    private String diagnosys;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "patient_has_diagnosys",
            joinColumns = @JoinColumn(name = "patientID"),
            inverseJoinColumns = @JoinColumn(name = "diagnosysID"))
    private Set<Patient> patients = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Diagnosys() {}

    public Diagnosys(String d) {
        this.setDiagnosys(d);
    }

    public Diagnosys(int id) {
        this.setId(id);
    }

    public String getDiagnosys() {
        return diagnosys;
    }

    public void setDiagnosys(String diagnosys) {
        this.diagnosys = diagnosys;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    public void addPatient(Patient patient){this.patients.add(patient);}

//    public Set<Doctor> getDoctors() {
//        return doctors;
//    }
//
//    public void setDoctors(Set<Doctor> doctors) {
//        this.doctors = doctors;
//    }
//
//    public void addDoctor(Doctor doc) { this.doctors.add(doc); }

}