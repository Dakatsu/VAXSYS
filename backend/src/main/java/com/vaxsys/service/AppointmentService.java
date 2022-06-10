package com.vaxsys.service;

import com.vaxsys.constant.Role;
import com.vaxsys.dto.AppointmentCreationDto;
import com.vaxsys.entity.Account;
import com.vaxsys.entity.Appointment;
import com.vaxsys.repository.AccountRepository;
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
    @Autowired
    private AccountService accountService;

    @Transactional
    public Appointment createAppointment(AppointmentCreationDto request){
        Account patient = accountService.findById(Util.getCurrentUser().getAccountId());
        // Only let patients book appointments.
        // TODO: Fix this.
        //if (!patient.getRole().equals(Role.PATIENT)) {
            //throw new IllegalArgumentException("Only patients can book appointments, not " + patient.getRole().toString() + ".");
        //}
        Appointment appointment = new Appointment(request.getSlot(), patient, request.getVaccine(), 1);
        slotRepository.updateStateToDisabled(request.getSlot().getId());
        return appointmentRepository.save(appointment);
    }

    public Page<Appointment> findAppointmentByCurrentUserId(Pageable pageable){
        return appointmentRepository.findAllByPatientId(Util.getCurrentUser().getAccountId(),pageable);
    }

    public Page<Appointment> findAll(Pageable pageable){
        return appointmentRepository.findAll(pageable);
    }
}
