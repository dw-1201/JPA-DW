package com.example.dw.service;

import com.example.dw.domain.entity.user.Users;
import com.example.dw.repository.user.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AdminUserService {


    private final UsersRepository usersRepository;

    //회원 상태 수정
    @Transactional
    public void modifyUserStatus(Long userId){
        Users users = usersRepository.findById(userId).get();
        users.recoverUsersState();

    }


}
