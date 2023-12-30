package com.example.dw.repository.admin;

import com.example.dw.domain.entity.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {


    Optional<Admin> findByAdminAccountAndAdminPassword(String adminAccount, String adminPassword);

}
