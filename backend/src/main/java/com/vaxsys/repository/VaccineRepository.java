package com.vaxsys.repository;

import com.vaxsys.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Integer> {
    Vaccine findByName(String name);
}
