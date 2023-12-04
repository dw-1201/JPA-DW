package com.example.dw.repository;

import com.example.dw.domain.entity.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

    //아이디 중복체크
    boolean existsByUserAccount(String usersAccount);
    //휴대폰번호 중복체크
    boolean existsByUserPhone(String userPhone);
    //이메일 중복체크
    boolean existsByUserEmail(String userEmail);
    //로그인
    Optional<Users> findByUserAccountAndUserPassword(String userAccount, String userPassword);
}
