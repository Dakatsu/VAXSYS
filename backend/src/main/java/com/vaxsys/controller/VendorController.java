package com.vaxsys.controller;

import com.vaxsys.dto.DiseaseCreationDto;
import com.vaxsys.dto.DiseaseDto;
import com.vaxsys.dto.VaccineCreationDto;
import com.vaxsys.dto.VaccineDto;
import com.vaxsys.entity.Disease;
import com.vaxsys.entity.Vaccine;
import com.vaxsys.mapper.DiseaseMapper;
import com.vaxsys.mapper.VaccineMapper;
import com.vaxsys.service.VaccineService;
import com.vaxsys.service.DiseaseService;
import com.vaxsys.service.VaccineService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    private final VaccineService vaccineService;
    private final DiseaseService diseaseService;

    public VendorController(VaccineService vaccineService, DiseaseService diseaseService) {
        this.vaccineService = vaccineService;
        this.diseaseService = diseaseService;
    }

    @PostMapping("/vaccine")
    public VaccineDto createVaccine(@RequestBody VaccineCreationDto vaccineCreationDto, HttpServletResponse response) throws IOException {
        Vaccine vaccine;
        try {
            vaccine = vaccineService.createVaccine(vaccineCreationDto);
        } catch (Exception e) {
            response.sendError(HttpStatus.FORBIDDEN.value(), "Vaccine with name " + vaccineCreationDto.getName() + " already exists");
            return null;
        }

        return VaccineMapper.INSTANCE.map(vaccine);
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

    @PostMapping("/disease")
    public DiseaseDto createDisease(@RequestBody DiseaseCreationDto diseaseCreationDto, HttpServletResponse response) throws IOException {
        Disease disease;
        try {
            disease = diseaseService.createDisease(diseaseCreationDto);
        } catch (Exception e) {
            response.sendError(HttpStatus.FORBIDDEN.value(), "Disease with name " + diseaseCreationDto.getName() + " already exists");
            return null;
        }
        return DiseaseMapper.INSTANCE.map(disease);
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
