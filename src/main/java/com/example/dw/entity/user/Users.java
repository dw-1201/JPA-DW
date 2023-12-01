package com.example.dw.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "users")
public class Users {
    @Id @GeneratedValue
    @Column(name = "uesr_id")
    private Long id;

    private String userName;
    private String userPassword;
    private String userEmail;
    private String userPhone;
    private LocalDateTime userJoinDate;
    private String userNickName;
    private String userIntroduction;

    @Embedded
    private Address address;

    @OneToOne(mappedBy = "users" ,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_file_id")
    private UserFile userFile;

    @OneToMany(mappedBy = "users")
//    @JoinColumn(name="pet_id")
    private List<Pet> pet = new ArrayList<>();

//    public Users(Long id, String userName, String userPassword, String userEmail, String userPhone, LocalDateTime userJoinDate, String userNickName, String userIntroduction, Address address, UserFile userFile, List<Pet> pet) {
//        this.id = id;
//        this.userName = userName;
//        this.userPassword = userPassword;
//        this.userEmail = userEmail;
//        this.userPhone = userPhone;
//        this.userJoinDate = userJoinDate;
//        this.userNickName = userNickName;
//        this.userIntroduction = userIntroduction;
//        this.address = address;
//        this.userFile = userFile;
//        this.pet = pet;
//    }
}
