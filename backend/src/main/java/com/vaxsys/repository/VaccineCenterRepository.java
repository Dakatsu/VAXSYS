package com.vaxsys.repository;

import com.vaxsys.entity.VaccineCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineCenterRepository extends JpaRepository<VaccineCenter, Integer> {
}