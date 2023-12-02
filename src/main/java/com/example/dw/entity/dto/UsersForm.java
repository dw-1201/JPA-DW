package com.example.dw.entity.dto;

import com.example.dw.entity.user.Pet;
import com.example.dw.entity.user.UserFile;
import com.example.dw.entity.user.Users;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class UsersForm  {

    private Long id;
//    @NotBlank(message ="아이디를 입력해주세요")
//    @Size(min=6, max=13, message = "영문 소문자, 숫자를 사용한 6~13자리이어야 합니다.")
//    @Pattern(regexp = "^[a-z0-9][a-z0-9]*$", message = "영문 소문자, 숫자를 사용한 6~13자리이어야 합니다.")
    private String userAccount;
    
//    @NotBlank(message = "비밀번호를 입력해주세요")
//    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[!@#$%^&*()_=+])(?=.*[0-9]).{8,15}$", message = "특수문자와 숫자를 포함하여 8자 이상 입력해주세요")
    private String userPassword;

//    @NotBlank
//    @Email(message = "이메일 양식이 아닙니다.")
    private String userEmail;
//    @NotBlank
    private String userPhone;

    private LocalDateTime userJoinDate;
    private String userNickName;
    private String userIntroduction;
    private String zipCode;
    private String address;
    private String detail;
    private UserFile userFile;
    private List<Pet> pet;


    @Builder
    public UsersForm(Long id, String userAccount, String userPassword, String userEmail, String userPhone, LocalDateTime userJoinDate,
                     String userNickName, String userIntroduction, String zipCode, String address, String detail, UserFile userFile, List<Pet> pet) {
        this.id = id;
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userJoinDate = userJoinDate;
        this.userNickName = userNickName;
        this.userIntroduction = userIntroduction;
        this.zipCode = zipCode;
        this.address = address;
        this.detail = detail;
        this.userFile = userFile;
        this.pet = pet;
    }



    public Users toEntity(){
        return Users.builder()
                .id(id)
                .userAccount(userAccount)
                .userPassword(userPassword)
                .userEmail(userEmail)
                .userPhone(userPhone)
                .userNickName(userNickName)
                .userIntroduction(userIntroduction)
                .zipCode(zipCode)
                .address(address)
                .detail(detail)
                .userFile(userFile)
                .pet(pet)
                .build();
    }

}
