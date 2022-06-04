package com.vaxsys.mapper;

import com.vaxsys.dto.VaccineDto;
import com.vaxsys.entity.Vaccine;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VaccineMapper {
    VaccineMapper INSTANCE = Mappers.getMapper(VaccineMapper.class);

    VaccineDto map(Vaccine source);

    List<VaccineDto> map(List<Vaccine> source);
}
