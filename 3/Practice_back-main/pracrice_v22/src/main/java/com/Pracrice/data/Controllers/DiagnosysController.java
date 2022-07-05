package com.Pracrice.data.Controllers;

import com.Pracrice.data.Classes.Diagnosys;
import com.Pracrice.data.Services.DiagnosysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/Diagnosys")
public class DiagnosysController {
    private final DiagnosysService diagnosysService;
@Autowired
    public DiagnosysController(DiagnosysService diagnosysService) {
        this.diagnosysService = diagnosysService;
    }
    @GetMapping
    public List<Diagnosys> getDiagnosys(){
    return diagnosysService.getDiagnosys();
    }
    @PostMapping
    public void addDiagnosys(@RequestBody Diagnosys diagnosys){
    diagnosysService.addDiagnoys(diagnosys.getDiagnosys());
    }
    @DeleteMapping(path="{iddiagnosys}")
    public void deleteDiagnosys(@PathVariable("iddiagnosys") int diagID){
    diagnosysService.deleteDiagnosys(diagID);
    }
    @PutMapping(path="{iddiagnosys}")
    public void updateDiagnosys(@PathVariable("iddiagnosys") int diagID, @RequestParam(required = false) String name){
    diagnosysService.updateDiagnosys(diagID,name);
    }
}
