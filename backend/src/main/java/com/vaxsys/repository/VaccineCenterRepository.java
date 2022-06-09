package com.vaxsys.repository;

import com.vaxsys.entity.VaccineCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineCenterRepository extends JpaRepository<VaccineCenter, Integer> {
    VaccineCenter findByName(String name);
}
