package com.vaxsys.service;

import com.vaxsys.dto.SlotCreationDto;
import com.vaxsys.dto.VaccineCreationDto;
import com.vaxsys.entity.Slot;
import com.vaxsys.entity.Vaccine;
import com.vaxsys.repository.SlotRepository;
import org.springframework.stereotype.Service;

@Service
public class SlotService {

    private final SlotRepository slotRepository;

    public SlotService(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    public Slot createSlot(SlotCreationDto slotCreationDto) {
        if (slotCreationDto.getVaccineCenter() == null) {
            throw new IllegalArgumentException();
        }
        Slot slot = new Slot(slotCreationDto.getTime(), slotCreationDto.getVaccineCenter());
        return slotRepository.save(slot);
    }
}
