package com.vaxsys.repository;

import com.vaxsys.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SlotRepository extends JpaRepository<Slot, Integer> {
    @Modifying
    @Query(value = "update Slot set enable = false where vaccine_center_id = ?1 and time = ?2")
    void updateStateByVaccineCenterIdAndTime(Integer vaccineCenterId, String time);

    @Modifying
    @Query(value = "update Slot set enable = false where id = ?1")
    void updateStateToDisabled(Integer id);


    @Query(value = "from Slot where vaccine_center_id = ?1 and enable = true")
    List<Slot> findByVaccine_center_id(Integer vaccine_center_id);
}