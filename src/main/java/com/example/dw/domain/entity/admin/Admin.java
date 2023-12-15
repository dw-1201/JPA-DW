package com.example.dw.domain.entity.admin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "admin")
@NoArgsConstructor
public class Admin {
    @Id
    @Column(name = "admin_id")
    private Long id;

    private String adminAccount;
    private String adminPassword;


    @Builder
    public Admin(Long id, String adminAccount, String adminPassword) {
        this.id = id;
        this.adminAccount = adminAccount;
        this.adminPassword = adminPassword;
    }
}
