package com.vaxsys.service;

import com.vaxsys.entity.Vaccine;
import com.vaxsys.repository.VaccineRepository;
import org.springframework.stereotype.Service;

@Service
public class VaccineService {

    private final VaccineRepository vaccineRepository;

    public VaccineService(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

    public Vaccine findByName(String name) {
        return vaccineRepository.findByName(name);
    }
}
