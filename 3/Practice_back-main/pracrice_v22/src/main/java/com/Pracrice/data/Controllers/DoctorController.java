package com.Pracrice.data.Controllers;

import com.Pracrice.data.Classes.Doctor;
import com.Pracrice.data.Services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/Doctor")
public class DoctorController {
    private final DoctorService doctorService;
@Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
    @GetMapping
    public List<Doctor> getDoctor(){
    return doctorService.getDoctor();
    }
    @PostMapping
    public void addDoctor(@RequestBody Doctor doctor){
    doctorService.addDoctor(doctor);
    }
    @DeleteMapping(path="{iddoctor}")
    public void deleteDoctor(@PathVariable("iddoctor") int doctorID){
        doctorService.deleteDoctor(doctorID);
    }
    @PutMapping(path="{iddoctor}")
    public void updateDoctor(@PathVariable("iddoctor") int doctorID,
                             @RequestParam(required = false) int patientID,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) int departmentID){
        doctorService.updateDoctor(doctorID,patientID,name,departmentID);
    }
}
