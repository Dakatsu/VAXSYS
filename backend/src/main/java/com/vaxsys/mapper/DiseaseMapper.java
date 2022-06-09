package com.vaxsys.mapper;

import com.vaxsys.dto.DiseaseDto;
import com.vaxsys.entity.Disease;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DiseaseMapper {

    DiseaseMapper INSTANCE = Mappers.getMapper(DiseaseMapper.class);

    DiseaseDto map(Disease source);

    List<DiseaseDto> map(List<Disease> source);
}
