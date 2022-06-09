package com.vaxsys.mapper;

import com.vaxsys.dto.AppointmentCreationDto;

import com.vaxsys.dto.AppointmentDto;
import com.vaxsys.entity.Appointment;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AppointmentMapper {

    AppointmentMapper INSTANCE = Mappers.getMapper(AppointmentMapper.class);

    AppointmentDto map(Appointment source);
}
