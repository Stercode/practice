package com.Pracrice.data.Services;

import com.Pracrice.data.Classes.Department;
import com.Pracrice.data.Classes.Diagnosys;
import com.Pracrice.data.Classes.Doctor;
import com.Pracrice.data.Classes.Patient;
import com.Pracrice.data.Repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
@Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
    public List<Doctor> getDoctor() {
        return doctorRepository.findAll();
    }

    public void addDoctor(Doctor dc) {
        if(doctorRepository.existsById(dc.getId())) throw new IllegalStateException("Doctor with id: " + dc.getId() + " already exists!");
        else {
            doctorRepository.save(dc);
            System.out.println(dc);
        }
    }

    public void deleteDoctor(int doctorID) {
        boolean exist = doctorRepository.existsById(doctorID);
        if (!exist) {
            throw new IllegalStateException("There is no hospital with id: " + doctorID);
        }
        doctorRepository.deleteById(doctorID);
    }

    @Transactional
    public void updateDoctor(int doctorID,int patientID, String name,int depID) {
        Doctor dc = doctorRepository.findById(doctorID).orElseThrow(() -> new IllegalStateException("Department with id " + doctorID + "does not exist!"));

        if (name != null && name.length() > 0 && !Objects.equals(dc.getName(), name)) {
            dc.setName(name);
        }
        if (depID !=0 && !Objects.equals(dc.getDepartmentID().getId(), depID)) dc.setDepartmentID(new Department(depID));
        if(patientID!=0) dc.addPatient(new Patient(patientID));
    }
}
