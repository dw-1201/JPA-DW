package com.example.dw.domain.form;

import com.example.dw.domain.embedded.Address;
import com.example.dw.domain.entity.question.Question;
import com.example.dw.domain.entity.user.UserFile;
import com.example.dw.domain.entity.user.Users;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class UserUpdateForm {

    private Long id;
    private String userAccount;
    private String userName;
    private String userNickName;
    private String userPhone;
    private String userEmail;
    private String userIntroduction;
    private String userPassword;
    private String zipCode;
    private String address;
    private String detail;

    @Builder
    public UserUpdateForm(Long id, String userAccount, String userName, String userNickName, String userPhone, String userEmail, String userIntroduction, String userPassword, String zipCode, String address, String detail) {
        this.id = id;
        this.userAccount = userAccount;
        this.userName = userName;
        this.userNickName = userNickName;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userIntroduction = userIntroduction;
        this.userPassword = userPassword;
        this.zipCode = zipCode;
        this.address = address;
        this.detail = detail;
    }

    public Users toEntity(){
        return  Users.builder()
                .id(id)
                .userAccount(userAccount)
                .userName(userName)
                .userNickName(userNickName)
                .userPhone(userPhone)
                .userEmail(userEmail)
                .userIntroduction(userIntroduction)
                .userPassword(userPassword)
                .address(new Address(zipCode,address,detail))
                .build();
    }


}
