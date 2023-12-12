package com.example.dw.api;


import com.example.dw.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/*")
public class UserApiController {


    private final UsersService usersService;

//    @PostMapping("/findAccout")
//    public boolean findAccount(String userName, String userPhone, String userEmail){
//
//
//
//
//    }


}
