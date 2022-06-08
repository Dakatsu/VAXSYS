package com.vaxsys.controller;

import com.vaxsys.dto.DiseaseDto;
import com.vaxsys.dto.VaccineDto;
import com.vaxsys.entity.Disease;
import com.vaxsys.entity.Vaccine;
import com.vaxsys.mapper.DiseaseMapper;
import com.vaxsys.mapper.VaccineMapper;
import com.vaxsys.repository.DiseaseRepository;
import com.vaxsys.repository.VaccineRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nurse")
public class NurseController {

    private final VaccineRepository vaccineRepository;
    private final DiseaseRepository diseaseRepository;

    public NurseController(VaccineRepository vaccineRepository, DiseaseRepository diseaseRepository) {
        this.vaccineRepository = vaccineRepository;
        this.diseaseRepository = diseaseRepository;
    }

    @GetMapping("/vaccine/{name}")
    public VaccineDto findVaccineByName(@PathVariable String name) {
        return VaccineMapper.INSTANCE.map(vaccineRepository.findByName(name));
    }

    @GetMapping("/vaccine")
    public Page<VaccineDto> findAllVaccines(Pageable pageable) {
        Page<Vaccine> vaccinePage = vaccineRepository.findAll(pageable);
        return new PageImpl<>(VaccineMapper.INSTANCE.map(vaccinePage.getContent()), pageable, vaccinePage.getTotalElements());
    }

    @GetMapping("/disease/{name}")
    public DiseaseDto findDiseaseByName(@PathVariable String name) {
        return DiseaseMapper.INSTANCE.map(diseaseRepository.findByName(name));
    }

    @GetMapping("/disease")
    public Page<DiseaseDto> findAllDiseases(Pageable pageable) {
        Page<Disease> diseasePage = diseaseRepository.findAll(pageable);
        return new PageImpl<>(DiseaseMapper.INSTANCE.map(diseasePage.getContent()), pageable, diseasePage.getTotalElements());
    }
}
