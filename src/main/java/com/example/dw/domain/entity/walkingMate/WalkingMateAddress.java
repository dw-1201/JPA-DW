package com.example.dw.domain.entity.walkingMate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "walking_mate_address")
public class WalkingMateAddress {
    @Id
    @GeneratedValue
    @Column(name = "walking_mate_address_id")
    private Long id;

    private String walkingMateAddressCity;
    private String walkingMateAddressCountry;
    private String walkingMateAddressDetail;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "walking_mate_id")
    private WalkingMate walkingMate;

}
