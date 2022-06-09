package com.vaxsys.service;

import com.vaxsys.dto.VaccineCenterCreationDto;
import com.vaxsys.entity.VaccineCenter;
import com.vaxsys.repository.VaccineCenterRepository;
import org.springframework.stereotype.Service;

@Service
public class VaccineCenterService {

    private final VaccineCenterRepository vaccineCenterRepository;

    public VaccineCenterService(VaccineCenterRepository vaccineCenterRepository) {
        this.vaccineCenterRepository = vaccineCenterRepository;
    }

    public VaccineCenter findByName(String name) {
        return vaccineCenterRepository.findByName(name);
    }

    public VaccineCenter createVaccineCenter(VaccineCenterCreationDto vaccineCenterCreationDto) {
        VaccineCenter vaccineCenter = new VaccineCenter(vaccineCenterCreationDto.getName(), vaccineCenterCreationDto.getAddress(),
                vaccineCenterCreationDto.getContact());
        return vaccineCenterRepository.save(vaccineCenter);
    }
}
