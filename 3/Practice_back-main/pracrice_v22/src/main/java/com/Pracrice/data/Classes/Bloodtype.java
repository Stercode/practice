package com.Pracrice.data.Classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "bloodtype")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Bloodtype {
    @Id
    @Column(name = "idbloodtype", nullable = false)
    private Integer id;

    @Column(name = "Type", nullable = false)
    private Integer type;

    @Column(name = "Rhesus", nullable = false)
    private Integer rhesus;

    @Column(name = "RW", nullable = false)
    private Integer rw;
    @JsonIgnore
    @OneToMany(mappedBy = "patientBloodID")
    private Set<Patient> patients = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public Bloodtype(){}
    public Bloodtype(int i){this.setId(i);}
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getRhesus() {
        return rhesus;
    }

    public void setRhesus(Integer rhesus) {
        this.rhesus = rhesus;
    }

    public Integer getRw() {
        return rw;
    }

    public void setRw(Integer rw) {
        this.rw = rw;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

}