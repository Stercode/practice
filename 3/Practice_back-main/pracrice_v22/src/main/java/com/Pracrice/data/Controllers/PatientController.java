package com.Pracrice.data.Controllers;

import com.Pracrice.data.Classes.Patient;
import com.Pracrice.data.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/Patient")
public class PatientController {
    private final PatientService patientService;
@Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    @GetMapping
    public List<Patient> getPatient(){
    return patientService.getPatient();
    }
    @PostMapping
    public void addPatient(@RequestBody Patient patient){
    patientService.addPatient(patient);
    }
    @DeleteMapping(path="{idPatient}")
    public void deletePatient(@PathVariable("idPatient") int patientID){
    patientService.deletePatient(patientID);
    }
    @PutMapping(path="{idPatient}")
    public void updatePatient(@PathVariable("idPatient") int patientID,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) int bth,
                              @RequestParam(required = false) int ph,
                              @RequestParam(required = false) int bld,
                              @RequestParam(required = false) int doctorID,
                              @RequestParam(required = false) int diagID){
    patientService.updatePatient(patientID,name,bth,ph,bld,doctorID,diagID);
    }
}
