package com.Pracrice.data.Services;

import com.Pracrice.data.Classes.Bloodtype;
import com.Pracrice.data.Repositories.BloodTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodTypeService {
    private final BloodTypeRepository bloodTypeRepository;

    @Autowired
    public BloodTypeService(BloodTypeRepository bloodTypeRepository) {
        this.bloodTypeRepository = bloodTypeRepository;
    }

    public List<Bloodtype> getBloodTypeRepository() {
        return bloodTypeRepository.findAll();
    }
}
