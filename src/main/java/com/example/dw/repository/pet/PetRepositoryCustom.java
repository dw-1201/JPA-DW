package com.example.dw.repository.pet;

import com.example.dw.domain.dto.admin.PetDetailResultDto;
import com.example.dw.domain.dto.admin.PetImgDetailDto;
import com.example.dw.domain.dto.admin.PetImgDto;

import java.util.List;
import java.util.Optional;

public interface PetRepositoryCustom {

    List<PetDetailResultDto> findAllById(Long userId);

    Optional<PetDetailResultDto> findByPetIdAndUserId(Long petId, Long userId);

    List<PetImgDto> findAllByPetId(Long petId);

}
