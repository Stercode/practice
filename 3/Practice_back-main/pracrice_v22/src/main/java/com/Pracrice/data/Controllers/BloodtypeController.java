package com.Pracrice.data.Controllers;

import com.Pracrice.data.Classes.Bloodtype;
import com.Pracrice.data.Services.BloodTypeService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.ManyToMany;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Bloodtype")
public class BloodtypeController {
    private final BloodTypeService bloodTypeService;

    @Autowired
    public BloodtypeController(BloodTypeService bloodTypeService) {
        this.bloodTypeService = bloodTypeService;
    }

    @GetMapping
    public List<Bloodtype> getBloodType(){
        return bloodTypeService.getBloodTypeRepository();
    }

//    @JsonIgnore
//    @ManyToMany
////    @JoinTable(name = "products_has_manufacturer",
////            joinColumns = @JoinColumn(name = "Products_ID"),
////            inverseJoinColumns = @JoinColumn(name = "Manufacturer_ID"))
//    private Set<Products> product = new HashSet<>();
//
//    public Set<Products> getProduct() {
//        return product;
//    }
}
