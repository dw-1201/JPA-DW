package com.example.dw.service;


import com.example.dw.domain.form.JoinForm;

import com.example.dw.domain.entity.user.Users;
import com.example.dw.repository.user.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UsersService {


    private final UsersRepository usersRepository;


    //아이디 중복체크
    @Transactional(readOnly = true)
    public boolean existsByUserAccount(String userAccount){
        return usersRepository.existsByUserAccount(userAccount);
    }

    //휴대폰 번호 중복체크
    @Transactional(readOnly = true)
    public boolean existsByUserPhone(String userPhone){
        return usersRepository.existsByUserPhone(userPhone);
    }

    //이메일 중복 체크
    @Transactional(readOnly = true)
    public boolean existsByUserEmail(String userEmail){
        return usersRepository.existsByUserEmail(userEmail);
    }

    //회원가입
    @Transactional
    public Long join(JoinForm joinForm){


        Users users = joinForm.toEntity();
        usersRepository.save(users);
        return users.getId();
    }

//    //유효성검사
//    public Map<String, String> validateHandling(Errors errors){
//        Map<String, String> validatorResult = new HashMap<>();
//
//        for (FieldError error : errors.getFieldErrors()) {
//            String validKeyName = String.format("valid_%s", error.getField());
//            validatorResult.put(validKeyName, error.getDefaultMessage());
//        }
//
//        return validatorResult;
//    }

    //로그인
    @Transactional
    public Users login(String userAccount, String userPassword){


         Optional<Users> findUser = usersRepository.findByUserAccountAndUserPassword(userAccount, userPassword);

         
         
         return Optional.ofNullable(findUser).orElseThrow(()-> new IllegalArgumentException("조회된 정보 없음")).get();
    }


    // 회워가입 수정
}
