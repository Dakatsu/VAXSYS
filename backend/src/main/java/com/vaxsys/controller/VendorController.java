package com.vaxsys.controller;

import com.vaxsys.dto.VaccineCreationDto;
import com.vaxsys.dto.VaccineDto;
import com.vaxsys.entity.Vaccine;
import com.vaxsys.mapper.VaccineMapper;
import com.vaxsys.repository.VaccineRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    private final VaccineRepository vaccineRepository;

    public VendorController(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

    @PostMapping("/vaccine")
    public VaccineDto createVaccine(@RequestBody VaccineCreationDto vaccineCreationDto) {
        Vaccine vaccine = new Vaccine(vaccineCreationDto.getName(), vaccineCreationDto.getDescription());
        return VaccineMapper.INSTANCE.map(vaccineRepository.save(vaccine));
    }

    @GetMapping("/vaccine/{name}")
    public VaccineDto findVaccineByName(@PathVariable String name) {
        return VaccineMapper.INSTANCE.map(vaccineRepository.findByName(name));
    }
}
