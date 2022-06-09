package com.vaxsys.service;

import com.vaxsys.dto.AppointmentCreationDto;
import com.vaxsys.entity.Appointment;
import com.vaxsys.repository.AppointmentRepository;
import com.vaxsys.repository.SlotRepository;
import com.vaxsys.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppointmentService {

    @Autowired
    private  AppointmentRepository appointmentRepository;
    @Autowired
    private SlotRepository slotRepository;

    @Transactional
    public Appointment createAppointment(AppointmentCreationDto request){
        Appointment appointment = new Appointment(request.getVaccineCenterId(),Util.getCurrentUser().getAccountId(), request.getVaccineId(),request.getTime());
        slotRepository.updateStateByVaccineCenterIdAndTime(request.getVaccineCenterId(),request.getTime());
        return appointmentRepository.save(appointment);
    }

    public Page<Appointment> findAppointmentByCurrentUserId(Pageable pageable){
        return appointmentRepository.findAllByPatientId(Util.getCurrentUser().getAccountId(),pageable);
    }

    public Page<Appointment> findAll(Pageable pageable){
        return appointmentRepository.findAll(pageable);
    }
}
