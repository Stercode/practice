package com.Pracrice.data.Services;

import com.Pracrice.data.Classes.Hospital;
import com.Pracrice.data.Classes.Plist;
import com.Pracrice.data.Repositories.PlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PlistService {
    private final PlistRepository plistRepository;

    @Autowired
    public PlistService(PlistRepository plistRepository) {
        this.plistRepository = plistRepository;
    }

    public List<Plist> getPlist() {
        return plistRepository.findAll();
    }

    public void addPlist(Plist pl) {
        if(plistRepository.existsById(pl.getId()))  throw new IllegalStateException("Plist with id: " + pl.getId() + " already exists!");
        else {
            plistRepository.save(pl);
            System.out.println(pl);
        }
    }

    public void deletePlist(int plistID) {
        boolean exist = plistRepository.existsById(plistID);
        if (!exist) {
            throw new IllegalStateException("There is no Plist with id: " + plistID);
        }
        plistRepository.deleteById(plistID);
    }
}
