package com.example.dw.entity.dto;


import com.example.dw.entity.user.Users;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginForm {

    private String userAccount;
    private String userPassword;

    @Builder
    public LoginForm(String userAccount, String userPassword) {
        this.userAccount = userAccount;
        this.userPassword = userPassword;
    }


    public Users toEntity(){
        return Users.builder()
                .userAccount(userAccount)
                .userPassword(userPassword)
                .build();
    }
}
