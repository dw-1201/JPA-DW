package com.example.dw.entity.user;

import com.example.dw.entity.freeBoard.FreeBoard;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@Getter
//@Setter
@Table(name = "users")
public class Users {
    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;


    private String userAccount;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userPhone;

    @Default
    private LocalDateTime userJoinDate = LocalDateTime.now();
    private String userNickName;
    private String userIntroduction;

    private String zipCode;
    private String address;
    private String detail;


    @OneToOne(mappedBy = "users" ,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_file_id")
    private UserFile userFile;

    @OneToMany(mappedBy = "users" ,fetch = FetchType.LAZY)
//    @JoinColumn(name="pet_id")
    private List<Pet> pet = new ArrayList<>();

    @OneToMany(mappedBy = "users" ,fetch = FetchType.LAZY)
    private List<FreeBoard> freeBoard = new ArrayList<>();


    @Builder
    public Users(Long id, String userAccount, String userName, String userPassword, String userEmail, String userPhone, LocalDateTime userJoinDate, String userNickName,
                 String userIntroduction, String zipCode, String address, String detail, UserFile userFile, List<Pet> pet , List<FreeBoard> freeBoard) {
        this.id = id;
        this.userAccount = userAccount;
        this.userName = userName;
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
        this.freeBoard = freeBoard;
    }
}
