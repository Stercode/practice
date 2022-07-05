package com.Pracrice.data.Controllers;

import com.Pracrice.data.Classes.Plist;
import com.Pracrice.data.Services.PlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Plist")
public class PlistController {
    private final PlistService plistService;

    @Autowired
    public PlistController(PlistService plistService) {
        this.plistService = plistService;
    }
    @GetMapping
    public List<Plist> getPlist(){
        return plistService.getPlist();
    }
    @PostMapping
    public void registerNewPlist(@RequestBody Plist plist){
        plistService.addPlist(plist);
    }

    @DeleteMapping(path="{idPlist}")
    public void deletePlist(@PathVariable("idPlist") int PlistID)
    {
        plistService.deletePlist(PlistID);
    }
}
