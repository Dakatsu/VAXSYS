package com.vaxsys.mapper;

import com.vaxsys.dto.VaccineCenterDto;
import com.vaxsys.entity.VaccineCenter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VaccineCenterMapper {
    VaccineCenterMapper INSTANCE = Mappers.getMapper(VaccineCenterMapper.class);

    VaccineCenterDto map(VaccineCenter source);

    List<VaccineCenterDto> map(List<VaccineCenter> source);
}
