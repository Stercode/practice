package com.Pracrice.data.Classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "patient")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPatient", nullable = false)
    private Integer id;

    @Column(name = "Pname", length = 45)
    private String pname;

    @Column(name = "Birthday")
    private Integer birthday;

    @Column(name = "Phone_number")
    private Integer phoneNumber;
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PatientID")
    private Plist patientID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PatientBloodID")
    private Bloodtype patientBloodID;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "doctor_has_patient",
            joinColumns = @JoinColumn(name = "doctorID"),
            inverseJoinColumns = @JoinColumn(name = "patientID"))
    private Set<Doctor> doctors = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "patient_has_diagnosys",
            joinColumns = @JoinColumn(name = "patientID"),
            inverseJoinColumns = @JoinColumn(name = "diagnosysID"))
    private Set<Diagnosys> diagnosys = new LinkedHashSet<>();

    public Patient(){}
    public Patient(int patientID){this.setId(patientID);}
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getBirthday() {
        return birthday;
    }

    public void setBirthday(Integer birthday) {
        this.birthday = birthday;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Plist getPatientID() {
        return patientID;
    }

    public void setPatientID(Plist patientID) {
        this.patientID = patientID;
    }

    public Bloodtype getPatientBloodID() {
        return patientBloodID;
    }

    public void setPatientBloodID(Bloodtype patientBloodID) {
        this.patientBloodID = patientBloodID;
    }

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void addDoctor(Doctor doctor){ this.doctors.add(doctor); }

    public Set<Diagnosys> getDiagnosys() {
        return diagnosys;
    }

    public void setDiagnosys(Set<Diagnosys> diagnosys) {
        this.diagnosys = diagnosys;
    }

    public void addDiagnosys(Diagnosys diagnosys){ this.diagnosys.add(diagnosys); }
}