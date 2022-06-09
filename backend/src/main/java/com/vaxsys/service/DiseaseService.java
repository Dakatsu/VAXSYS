package com.vaxsys.service;

import com.vaxsys.dto.DiseaseCreationDto;
import com.vaxsys.entity.Disease;
import com.vaxsys.repository.DiseaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DiseaseService {

    private final DiseaseRepository diseaseRepository;

    public DiseaseService(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    public Disease findByName(String name) {
        return diseaseRepository.findByName(name);
    }

    public Page<Disease> findAll(Pageable pageable) {
        return diseaseRepository.findAll(pageable);
    }

    public Disease createDisease(DiseaseCreationDto diseaseCreationDto) {
        if (diseaseRepository.findByName(diseaseCreationDto.getName()) != null) {
            throw new IllegalArgumentException();
        }
        Disease disease = new Disease(diseaseCreationDto.getName(), diseaseCreationDto.getDescription());
        return diseaseRepository.save(disease);
    }
}
