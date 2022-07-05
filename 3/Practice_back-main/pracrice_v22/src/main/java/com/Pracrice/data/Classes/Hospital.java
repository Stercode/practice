package com.Pracrice.data.Classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "hospital")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Hospital {
    @Id
    @Column(name = "idhospital", nullable = false)
    private Integer id;

    @Column(name = "Numb", nullable = false)
    private Integer numb;
    @JsonIgnore
    @OneToMany(mappedBy = "hospitalID")
    private Set<Department> departments = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumb() {
        return numb;
    }

    public Hospital(){}
    public Hospital(int hospID){
        this.setId(hospID);
        this.setNumb(hospID);
    }
    public void setNumb(Integer numb) {
        this.numb = numb;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }
    public void addDepartments(Department department){this.departments.add(department);}

}