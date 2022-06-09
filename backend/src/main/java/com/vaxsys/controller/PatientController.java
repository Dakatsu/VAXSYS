package com.vaxsys.controller;

import com.vaxsys.dto.AppointmentCreationDto;
import com.vaxsys.dto.AppointmentDto;
import com.vaxsys.dto.SlotDto;
import com.vaxsys.dto.DiseaseDto;
import com.vaxsys.dto.VaccineDto;
import com.vaxsys.entity.Appointment;
import com.vaxsys.entity.Slot;
import com.vaxsys.entity.Vaccine;
import com.vaxsys.entity.VaccineCenter;
import com.vaxsys.mapper.AppointmentMapper;
import com.vaxsys.mapper.SlotMapper;
import com.vaxsys.entity.Disease;
import com.vaxsys.mapper.DiseaseMapper;
import com.vaxsys.mapper.VaccineMapper;
import com.vaxsys.repository.SlotRepository;
import com.vaxsys.repository.VaccineCenterRepository;
import com.vaxsys.repository.DiseaseRepository;
import com.vaxsys.repository.VaccineRepository;
import com.vaxsys.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    private final VaccineRepository vaccineRepository;
    private final DiseaseRepository diseaseRepository;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private VaccineCenterRepository vaccineCenterRepository;

    @Autowired
    private SlotRepository slotRepository;



    public PatientController(VaccineRepository vaccineRepository, DiseaseRepository diseaseRepository) {
        this.vaccineRepository = vaccineRepository;
        this.diseaseRepository = diseaseRepository;
    }

    @GetMapping("/vaccine/{name}")
    public VaccineDto findVaccineByName(@PathVariable String name) {
        return VaccineMapper.INSTANCE.map(vaccineRepository.findByName(name));
    }

    @GetMapping("/vaccine/findAll")
    public List<VaccineDto> findAllVaccine(){
        return VaccineMapper.INSTANCE.map(vaccineRepository.findAll());
    }

    @GetMapping("/vaccineCenter/findAll")
    public List<VaccineCenter> findAllVaccineCenter(){
        return vaccineCenterRepository.findAll();
    }

    @PostMapping("/appointment/create")
    public AppointmentDto createAppointment(@RequestBody AppointmentCreationDto appointmentCreationDto){
        Appointment appointment = appointmentService.createAppointment(appointmentCreationDto);
        return AppointmentMapper.INSTANCE.map(appointment);
    }

    @GetMapping("/appointment/findAll")
    public Page<Appointment> findAllAppointments(Pageable pageable){
        Page<Appointment> appointmentPage = appointmentService.findAppointmentByCurrentUserId(pageable);
        return new PageImpl<>(appointmentPage.getContent(),pageable,appointmentPage.getTotalElements());
    }

    @GetMapping("/appointment/findSlotByVaccineCenterId/{Id}")
    public List<SlotDto> findSlotByVaccineCenterId(@PathVariable Integer Id){
        List<Slot> times = slotRepository.findByVaccine_center_id(Id);
        return SlotMapper.INSTANCE.map(times);
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
