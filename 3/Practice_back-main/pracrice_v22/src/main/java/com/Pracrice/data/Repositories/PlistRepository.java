package com.Pracrice.data.Repositories;

import com.Pracrice.data.Classes.Plist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlistRepository extends JpaRepository<Plist,Integer> {
}
