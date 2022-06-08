package com.vaxsys.repository;

import com.vaxsys.entity.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseaseRepository extends JpaRepository<Disease, Integer> {

    Disease findByName(String name);
}
