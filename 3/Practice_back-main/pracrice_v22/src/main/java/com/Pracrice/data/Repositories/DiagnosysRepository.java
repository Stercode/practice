package com.Pracrice.data.Repositories;

import com.Pracrice.data.Classes.Diagnosys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosysRepository extends JpaRepository<Diagnosys,Integer> {
}
