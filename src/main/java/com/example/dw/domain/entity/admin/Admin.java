package com.example.dw.domain.entity.admin;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "admin")
@NoArgsConstructor
public class Admin {
    @Id
    @Column(name = "admin_id")
    private Long id;

    private String adminAccount;
    private String adminPassword;



}
