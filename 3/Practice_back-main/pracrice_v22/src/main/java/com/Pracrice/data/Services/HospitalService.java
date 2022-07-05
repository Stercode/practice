package com.Pracrice.data.Services;

import com.Pracrice.data.Classes.Hospital;
import com.Pracrice.data.Repositories.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    @Autowired
    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public List<Hospital> getHospital() {
        return hospitalRepository.findAll();
    }

    public void addHospital(Hospital hp) {
        if(hospitalRepository.existsById(hp.getId())) throw new IllegalStateException("Hospital with id: " + hp.getId() + " already exists!");
        else {
            hospitalRepository.save(hp);
            System.out.println(hp);
        }
    }

    public void deleteHospital(int hospitalID) {
        boolean exist = hospitalRepository.existsById(hospitalID);
        if (!exist) {
            throw new IllegalStateException("There is no hospital with id: " + hospitalID);
        }
        hospitalRepository.deleteById(hospitalID);
    }
}

