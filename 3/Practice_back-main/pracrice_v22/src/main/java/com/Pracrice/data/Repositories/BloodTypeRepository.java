package com.Pracrice.data.Repositories;

import com.Pracrice.data.Classes.Bloodtype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodTypeRepository extends JpaRepository<Bloodtype,Integer> {
}
