package com.example.dw.domain.form;


import com.example.dw.domain.entity.user.Pet;
import com.example.dw.domain.entity.user.Users;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class PetForm {

    private Long id;
    private String name;
    private String birthDate;
    private String petCategory;
    private String petGender;
    private String neutering;
    private Long weight;
    private Long userId;

    @Builder
    public PetForm(Long id, String name, String birthDate, String petCategory, String petGender, String neutering, Long weight, Long userId) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.petCategory = petCategory;
        this.petGender = petGender;
        this.neutering = neutering;
        this.weight = weight;
        this.userId = userId;
    }

    public Pet toEntity(){
        return  Pet.builder()
                .id(id)
                .name(name)
                .birthDate(birthDate)
                .petCategory(petCategory)
                .petGender(petGender)
                .neutering(neutering)
                .weight(weight)
                .users(Users.builder().id(userId).build())
                .build();
    }

}
