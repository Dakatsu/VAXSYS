package com.vaxsys.service;

import com.vaxsys.entity.Disease;
import com.vaxsys.repository.DiseaseRepository;

public class DiseaseService {

    private final DiseaseRepository diseaseRepository;

    public DiseaseService(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    public Disease findByName(String name) {
        return diseaseRepository.findByName(name);
    }
}
