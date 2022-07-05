package com.Pracrice.data.Services;

import com.Pracrice.data.Classes.Diagnosys;
import com.Pracrice.data.Classes.Doctor;
import com.Pracrice.data.Classes.Patient;
import com.Pracrice.data.Repositories.DiagnosysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class DiagnosysService {
    private final DiagnosysRepository diagnosysRepository;

    @Autowired
    public DiagnosysService(DiagnosysRepository diagnosysRepository) {
        this.diagnosysRepository = diagnosysRepository;
    }

    public List<Diagnosys> getDiagnosys() {
        return diagnosysRepository.findAll();
    }

    public void addDiagnoys(String d) {
        Diagnosys diagnosys = new Diagnosys(d);
        List<Diagnosys> ds = this.getDiagnosys();
        boolean o = false;
        for (Diagnosys value : ds) {
            if (Objects.equals(value.getDiagnosys(), d)) {
                o = true;
                break;
            }
        }
        if (o) {throw new IllegalStateException("Diagnosys with name: " + d + " already exists!");}
        else {
            diagnosys.setId(ds.size() + 1);
            diagnosysRepository.save(diagnosys);
            System.out.println(d);
        }
    }

    public void deleteDiagnosys(int idDiagnosys) {
        boolean exists = diagnosysRepository.existsById(idDiagnosys);
        if (!exists) {
            throw new IllegalStateException("Diagnosys with id " + idDiagnosys + " does not exists");
        }
        diagnosysRepository.deleteById(idDiagnosys);
    }

    @Transactional
    public void updateDiagnosys(int id, String name) {
        Diagnosys ds = diagnosysRepository.findById(id).orElseThrow(() -> new IllegalStateException("diagnosys with id " + id + "does not exists"));

        if (name != null && name.length() > 0 && !Objects.equals(ds.getDiagnosys(), name)) {
            ds.setDiagnosys(name);
        }
        //if(patientID!=0) ds.addPatient(new Patient(patientID));
    }
}