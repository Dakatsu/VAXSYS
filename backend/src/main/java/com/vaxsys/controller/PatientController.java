package com.vaxsys.controller;

import com.vaxsys.dto.DiseaseDto;
import com.vaxsys.dto.VaccineDto;
import com.vaxsys.entity.Disease;
import com.vaxsys.entity.Vaccine;
import com.vaxsys.mapper.DiseaseMapper;
import com.vaxsys.mapper.VaccineMapper;
import com.vaxsys.repository.DiseaseRepository;
import com.vaxsys.repository.VaccineRepository;
import com.vaxsys.service.DiseaseService;
import com.vaxsys.service.VaccineService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final VaccineService vaccineService;
    private final DiseaseService diseaseService;

    public PatientController(VaccineService vaccineService, DiseaseService diseaseService) {
        this.vaccineService = vaccineService;
        this.diseaseService = diseaseService;
    }

    @GetMapping("/vaccine/{name}")
    public VaccineDto findVaccineByName(@PathVariable String name) {
        return VaccineMapper.INSTANCE.map(vaccineService.findByName(name));
    }

    @GetMapping("/vaccine")
    public Page<VaccineDto> findAllVaccines(Pageable pageable) {
        Page<Vaccine> vaccinePage = vaccineService.findAll(pageable);
        return new PageImpl<>(VaccineMapper.INSTANCE.map(vaccinePage.getContent()), pageable, vaccinePage.getTotalElements());
    }

    @GetMapping("/disease/{name}")
    public DiseaseDto findDiseaseByName(@PathVariable String name) {
        return DiseaseMapper.INSTANCE.map(diseaseService.findByName(name));
    }

    @GetMapping("/disease")
    public Page<DiseaseDto> findAllDiseases(Pageable pageable) {
        Page<Disease> diseasePage = diseaseService.findAll(pageable);
        return new PageImpl<>(DiseaseMapper.INSTANCE.map(diseasePage.getContent()), pageable, diseasePage.getTotalElements());
    }
}
