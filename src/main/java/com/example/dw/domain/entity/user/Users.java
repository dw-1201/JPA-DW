package com.example.dw.domain.entity.user;

import com.example.dw.domain.embedded.Address;
import com.example.dw.domain.entity.freeBoard.FreeBoard;
import com.example.dw.domain.entity.freeBoard.FreeBoardComment;
import com.example.dw.domain.entity.question.Question;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@SQLDelete(sql="UPDATE users set user_state = 0 where user_id = ?")
@EntityListeners(AuditingEntityListener.class)
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

    @CreatedDate
    private String userJoinDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
    private String userNickName;
    private String userIntroduction;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="zipCode", column = @Column(name="zip_code")),
            @AttributeOverride(name="address", column = @Column(name="address")),
            @AttributeOverride(name="detail", column = @Column(name="detail")),
    })
    private Address address;


    @OneToOne(mappedBy = "users" ,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_file_id")
    private UserFile userFile;

    @OneToMany(mappedBy = "users", orphanRemoval = true)
    private List<Pet> pet = new ArrayList<>();

    @OneToMany(mappedBy = "users" ,fetch = FetchType.LAZY)
    private List<FreeBoard> freeBoard = new ArrayList<>();
    @OneToMany(mappedBy = "users",fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Question> questions =new ArrayList<>();
    @OneToMany(mappedBy = "users", orphanRemoval = true)
    private List<FreeBoardComment> freeBoardComments = new ArrayList<>();

    @Builder.Default
    private int userState = 1;

    @Builder
    public Users(Long id, String userAccount, String userName, String userPassword, String userEmail, String userPhone,
                 String userJoinDate, String userNickName,
                 String userIntroduction, Address address,
                 UserFile userFile, List<Pet> pet,List<FreeBoard> freeBoard, List<Question> questions,
                 List<FreeBoardComment> freeBoardComments, int userState) {
        this.id = id;
        this.userAccount = userAccount;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userJoinDate = userJoinDate;
        this.userNickName = userNickName;
        this.userIntroduction = userIntroduction;
        this.address=address;
        this.userFile = userFile;
        this.pet = pet;
        this.freeBoard = freeBoard;
        this.questions= questions;
        this.freeBoardComments = freeBoardComments;
        this.userState=userState;
    }


    //임시비밀번호로 비밀번호 수정
    public Users updatePassword(String rePassword){
        this.userPassword=rePassword;
        return this;
    }
}
