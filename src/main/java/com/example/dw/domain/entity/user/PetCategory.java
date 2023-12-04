package com.example.dw.domain.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name="pet_category")
public class PetCategory {
    @Id
    @GeneratedValue @Column(name = "pet_category_id")
    private Long id;

    private String categoryName;

    @OneToMany(mappedBy = "petCategory", fetch = FetchType.LAZY)
    private List<Pet> pet = new ArrayList<>();

}
