package com.vaxsys.service;

import com.vaxsys.dto.VaccineCreationDto;
import com.vaxsys.entity.Vaccine;
import com.vaxsys.repository.VaccineRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Vaccine createVaccine(VaccineCreationDto vaccineCreationDto) {
        if (vaccineRepository.findByName(vaccineCreationDto.getName()) != null) {
            throw new IllegalArgumentException();
        }
        Vaccine vaccine = new Vaccine(vaccineCreationDto.getName(), vaccineCreationDto.getDescription(), vaccineCreationDto.getInstruction(), vaccineCreationDto.getDoseRequired(), vaccineCreationDto.getDisease());
        return vaccineRepository.save(vaccine);
    }

    public Page<Vaccine> findAll(Pageable pageable) {
        return vaccineRepository.findAll(pageable);
    }
}
