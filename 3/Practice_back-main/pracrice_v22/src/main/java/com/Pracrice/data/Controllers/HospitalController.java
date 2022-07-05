package com.Pracrice.data.Controllers;

import com.Pracrice.data.Classes.Hospital;
import com.Pracrice.data.Services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Hospital")
public class HospitalController {
    private final HospitalService hospitalService;

    @Autowired
    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }
    @GetMapping
    public List<Hospital> getHopital(){
        return hospitalService.getHospital();
    }
    @PostMapping
    public void registerNewHospital(@RequestBody Hospital hospital){
        hospitalService.addHospital(hospital);
    }
    @DeleteMapping(path="{idhospital}")
    public void deleteHospital(@PathVariable("idhospital") int hospitalID){
        hospitalService.deleteHospital(hospitalID);
    }
}
