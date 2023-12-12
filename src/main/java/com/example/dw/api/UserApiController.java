package com.example.dw.api;


import com.example.dw.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/*")
public class UserApiController {


    private final UsersService usersService;








}
