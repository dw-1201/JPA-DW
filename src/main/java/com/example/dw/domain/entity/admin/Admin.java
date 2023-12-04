package com.example.dw.domain.entity.admin;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue
    @Column(name = "admin_id")
    private Long id;

    private String adminAccount;
    private String adminPassword;
}
