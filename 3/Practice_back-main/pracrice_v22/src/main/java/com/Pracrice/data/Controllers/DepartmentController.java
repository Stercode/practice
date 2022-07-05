package com.Pracrice.data.Controllers;

import com.Pracrice.data.Classes.Department;
import com.Pracrice.data.Services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping
    public List<Department> getDepartment(){
        return departmentService.getDepartment();
    }
    @PostMapping
    public void addDepartment(@RequestBody Department department){
        departmentService.addDepartment(department);
    }
    @DeleteMapping(path="{iddepartment}")
    public void deleteDepartment(@PathVariable("iddepartment") int departmentID){
        departmentService.deleteDepartment(departmentID);
    }
    @PutMapping(path="{iddepartment}")
    public void updateDepartment(@PathVariable("iddepartment") int departmentID,
                                 @RequestParam(required = false) String name,
                                 @RequestParam(required = false) int hospID){
        departmentService.updateDepartment(departmentID,name,hospID);
    }
}
