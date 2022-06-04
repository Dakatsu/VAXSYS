package com.vaxsys.controller;

import com.vaxsys.dto.VaccineDto;
import com.vaxsys.mapper.VaccineMapper;
import com.vaxsys.repository.VaccineRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final VaccineRepository vaccineRepository;

    public PatientController(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

    @GetMapping("/vaccine/{name}")
    public VaccineDto findVaccineByName(@PathVariable String name) {
        return VaccineMapper.INSTANCE.map(vaccineRepository.findByName(name));
    }
}
