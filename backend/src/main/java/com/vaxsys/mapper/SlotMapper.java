package com.vaxsys.mapper;

import com.vaxsys.dto.SlotDto;
import com.vaxsys.entity.Slot;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SlotMapper {
    SlotMapper INSTANCE = Mappers.getMapper(SlotMapper.class);

    SlotDto map(Slot source);
    List<SlotDto> map(List<Slot> source);

}
