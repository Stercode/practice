package com.Pracrice.data.Services;

import com.Pracrice.data.Classes.Department;
import com.Pracrice.data.Classes.Hospital;
import com.Pracrice.data.Classes.Plist;
import com.Pracrice.data.Repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getDepartment() {
        return departmentRepository.findAll();
    }

    public void addDepartment(Department dp) {
        if(departmentRepository.existsById(dp.getId()))  throw new IllegalStateException("Department with id: " + dp.getId() + " already exists!");
        else {
            departmentRepository.save(dp);
            System.out.println(dp);
        }
    }

    public void deleteDepartment(int departmentID) {
        boolean exist = departmentRepository.existsById(departmentID);
        if (!exist) {
            throw new IllegalStateException("There is no hospital with id: " + departmentID);
        }
        departmentRepository.deleteById(departmentID);
    }

    @Transactional
    public void updateDepartment(int departmentID, String name, int hospID) {
        Department dp = departmentRepository.findById(departmentID).orElseThrow(() -> new IllegalStateException("Department with id " + departmentID + "does not exist!"));

        if (name != null && name.length() > 0 && !Objects.equals(dp.getName(), name)) {
            dp.setName(name);
        }
        if (hospID != 0 && !Objects.equals(dp.getHospitalID().getId(), hospID)) dp.setHospitalID(new Hospital(hospID));
    }
}
