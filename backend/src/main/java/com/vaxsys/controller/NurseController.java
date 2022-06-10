package com.vaxsys.controller;

import com.vaxsys.dto.*;
import com.vaxsys.entity.Disease;
import com.vaxsys.entity.Appointment;
import com.vaxsys.entity.Slot;
import com.vaxsys.entity.Vaccine;
import com.vaxsys.mapper.DiseaseMapper;
import com.vaxsys.mapper.SlotMapper;
import com.vaxsys.mapper.VaccineMapper;
import com.vaxsys.service.AppointmentService;
import com.vaxsys.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import com.vaxsys.service.DiseaseService;
import com.vaxsys.service.VaccineService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/nurse")
public class NurseController {

    private final VaccineService vaccineService;
    private final DiseaseService diseaseService;
    private final SlotService slotService;

    @Autowired
    private AppointmentService appointmentService;

    public NurseController(VaccineService vaccineService, DiseaseService diseaseService, SlotService slotService) {
        this.vaccineService = vaccineService;
        this.diseaseService = diseaseService;
        this.slotService = slotService;
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

    @GetMapping("/appointment/findAll")
    public Page<Appointment> findAllAppointments(Pageable pageable){
        Page<Appointment> appointmentPage = appointmentService.findAll(pageable);
        return new PageImpl<>(appointmentPage.getContent(),pageable,appointmentPage.getTotalElements());
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

    @PostMapping("/slot")
    public SlotDto createSlot(@RequestBody SlotCreationDto slotCreationDto, HttpServletResponse response) throws IOException {
        Slot slot;
        try {
            slot = slotService.createSlot(slotCreationDto);
        } catch(Exception e) {
            response.sendError(HttpStatus.FORBIDDEN.value(), "Unable to create slot: " + e.getMessage());
            return null;
        }
        return SlotMapper.INSTANCE.map(slot);
    }
}
