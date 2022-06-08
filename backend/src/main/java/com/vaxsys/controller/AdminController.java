package com.vaxsys.controller;

import com.vaxsys.dto.*;
import com.vaxsys.entity.Account;
import com.vaxsys.entity.Disease;
import com.vaxsys.entity.Vaccine;
import com.vaxsys.mapper.AccountMapper;
import com.vaxsys.mapper.DiseaseMapper;
import com.vaxsys.mapper.VaccineMapper;
import com.vaxsys.repository.DiseaseRepository;
import com.vaxsys.repository.VaccineRepository;
import com.vaxsys.service.AccountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.vaxsys.constant.Role.ADMIN_CREATION_ROLES;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AccountService accountService;
    private final VaccineRepository vaccineRepository;
    private final DiseaseRepository diseaseRepository;

    public AdminController(AccountService accountService, VaccineRepository vaccineRepository, DiseaseRepository diseaseRepository) {
        this.accountService = accountService;
        this.vaccineRepository = vaccineRepository;
        this.diseaseRepository = diseaseRepository;
    }

    @PostMapping("/account")
    public AccountDto createAccount(@RequestBody AccountCreationDto accountCreationDto,
                                    HttpServletResponse response) throws IOException {
        Account account;
        if (!ADMIN_CREATION_ROLES.contains(accountCreationDto.getRole())) {
            response.sendError(HttpStatus.FORBIDDEN.value(), "Admin could only create nurse or vendor accounts.");
            return null;
        }
        try {
            account = accountService.createAccount(accountCreationDto, accountCreationDto.getRole().map());
        } catch (Exception e) {
            response.sendError(HttpStatus.FORBIDDEN.value(), e.getMessage());
            return null;
        }
        return AccountMapper.INSTANCE.map(account);
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
