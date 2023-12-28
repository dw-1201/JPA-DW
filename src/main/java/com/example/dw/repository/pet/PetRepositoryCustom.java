package com.example.dw.repository.pet;

import com.example.dw.domain.dto.admin.PetDetailResultDto;

import java.util.List;

public interface PetRepositoryCustom {

    List<PetDetailResultDto> findAllById(Long userId);


}
