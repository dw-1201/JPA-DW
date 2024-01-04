package com.example.dw.service;

import com.example.dw.repository.user.UsersRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final HttpSession httpSession;
    private final UsersRepository usersRepository;

    //주문서 작성
//    @Transactional
//    public Long register(OrderForm orderForm){
//
//        Long userId = (Long)httpSession.getAttribute("userId");
//        Users user = usersRepository.findById(userId).orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));
//
//        Order order =
//
//    }
}
