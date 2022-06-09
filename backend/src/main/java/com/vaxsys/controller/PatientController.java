package com.vaxsys.controller;

import com.vaxsys.dto.AppointmentCreationDto;
import com.vaxsys.dto.AppointmentDto;
import com.vaxsys.dto.SlotDto;
import com.vaxsys.dto.VaccineDto;
import com.vaxsys.entity.Appointment;
import com.vaxsys.entity.Slot;
import com.vaxsys.entity.Vaccine;
import com.vaxsys.entity.VaccineCenter;
import com.vaxsys.mapper.AppointmentMapper;
import com.vaxsys.mapper.SlotMapper;
import com.vaxsys.mapper.VaccineMapper;
import com.vaxsys.repository.SlotRepository;
import com.vaxsys.repository.VaccineCenterRepository;
import com.vaxsys.repository.VaccineRepository;
import com.vaxsys.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final VaccineRepository vaccineRepository;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private VaccineCenterRepository vaccineCenterRepository;

    @Autowired
    private SlotRepository slotRepository;


    public PatientController(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
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
}
