package com.vaxsys.controller;

import com.vaxsys.dto.VaccineDto;
import com.vaxsys.entity.Vaccine;
import com.vaxsys.mapper.VaccineMapper;
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

    public NurseController(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
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
}
