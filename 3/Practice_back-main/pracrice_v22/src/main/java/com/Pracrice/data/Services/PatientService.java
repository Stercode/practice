package com.Pracrice.data.Services;

import com.Pracrice.data.Classes.*;
import com.Pracrice.data.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getPatient() {
        return patientRepository.findAll();
    }

    public void addPatient(Patient pt) {
        if(patientRepository.existsById(pt.getId())) throw new IllegalStateException("Patient with id: " + pt.getId() + " already exists!");
        else {
           patientRepository.save(pt);
           System.out.println(pt);
        }
    }

    public void deletePatient(int idPatient) {
        boolean exists = patientRepository.existsById(idPatient);
        if (!exists) {
            throw new IllegalStateException("Patient with id " + idPatient + " does not exists");
        }
        patientRepository.deleteById(idPatient);
    }

    @Transactional
    public void updatePatient  (int ID, String name, int bth, int ph, int bld, int doctorID, int diagID) {
        Patient patient = patientRepository.findById(ID).orElseThrow(() -> new IllegalStateException("products with id " + ID + "does not exists"));

        if (name != null && name.length() > 0 && !Objects.equals(patient.getPname(), name)) {
            patient.setPname(name);
        }
        if (bth != 0 && !Objects.equals(patient.getBirthday(), bth)) patient.setBirthday(bth);
        if (ph != 0 && !Objects.equals(patient.getPhoneNumber(), ph)) patient.setPhoneNumber(ph);
        //
        if ((bld >= 1 && bld <= 16) && !Objects.equals(patient.getPatientBloodID().getId(), bld)) patient.setPatientBloodID(new Bloodtype(bld));
        if (doctorID !=0) patient.addDoctor(new Doctor(doctorID));
        if (diagID!=0) patient.addDiagnosys(new Diagnosys(diagID));
    }
}
