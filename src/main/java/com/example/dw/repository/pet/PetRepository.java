package com.example.dw.repository.pet;

import com.example.dw.domain.entity.question.Question;
import com.example.dw.domain.entity.user.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet,Long> {

    Optional<Pet> findById(Long id);
    void deletePetById(Long id);

}
