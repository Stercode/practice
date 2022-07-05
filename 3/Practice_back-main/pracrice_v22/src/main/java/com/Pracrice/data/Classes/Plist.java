package com.Pracrice.data.Classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "plist")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Plist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPlist", nullable = false)
    private Integer id;

    @Column(name = "Pnumber", nullable = false)
    private Integer pnumber;
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "patientID")
    private Patient patient;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPnumber() {
        return pnumber;
    }

    public void setPnumber(Integer pnumber) {
        this.pnumber = pnumber;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}