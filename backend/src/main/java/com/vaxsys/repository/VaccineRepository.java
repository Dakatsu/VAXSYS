package com.vaxsys.repository;

import com.vaxsys.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Integer> {
    Vaccine findByName(String name);

    @Query(value = "select * from vaccine v where v.id not in (select vaccine_id from appointment where patient_id = ?1)",nativeQuery = true)
    List<Vaccine> findAvailableVaccines(Integer patientId);
    Vaccine findByDisease_Id(int diseaseId);

}

