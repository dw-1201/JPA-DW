package com.example.dw.domain.entity.user;

import com.example.dw.domain.embedded.Address;
import com.example.dw.domain.entity.freeBoard.FreeBoard;
import com.example.dw.domain.entity.freeBoard.FreeBoardComment;
import com.example.dw.domain.entity.question.Question;
import com.example.dw.domain.form.UserUpdateForm;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql="UPDATE users set user_state = 0 where user_id = ?")
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
    private LocalDate userJoinDate ;

    @CreatedDate
    private LocalDate userDeleteDate;


    private String userNickName;
    private String userIntroduction;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="zipCode", column = @Column(name="zip_code")),
            @AttributeOverride(name="address", column = @Column(name="address")),
            @AttributeOverride(name="detail", column = @Column(name="detail")),
    })
    private Address address;


    @OneToMany(mappedBy = "users" ,fetch = FetchType.LAZY)
    private List<UserFile> userFile = new ArrayList<>();

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
                 LocalDate userJoinDate, LocalDate userDeleteDate, String userNickName,
                 String userIntroduction, Address address,
                 List<UserFile> userFile, List<Pet> pet,List<FreeBoard> freeBoard, List<Question> questions,
                 List<FreeBoardComment> freeBoardComments, int userState) {
        this.id = id;
        this.userAccount = userAccount;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userJoinDate = userJoinDate;
        this.userDeleteDate = userDeleteDate;
        this.userNickName = userNickName;
        this.userIntroduction = userIntroduction;
        this.address = address;
        this.userFile = userFile;
        this.pet = pet;
        this.freeBoard = freeBoard;
        this.questions= questions;
        this.freeBoardComments = freeBoardComments;
        this.userState=userState;
        this.questions = questions;
        this.userState = userState;
    }

    //임시비밀번호로 비밀번호 수정
    public Users updatePassword(String rePassword){
        this.userPassword=rePassword;
        return this;
    }

    //회원복구
    public Users recoverUsersState(){
        this.userState=1;
        return this;
    }

    //회원 탈퇴일자
    public Users deleteDate(){
        this.userDeleteDate=LocalDate.now();
        return this;
    }

    //회원 정보 수정
    public Users update(UserUpdateForm userUpdateForm){
        this.id=userUpdateForm.getId();
        this.userAccount=userUpdateForm.getUserAccount();
        this.userName=userUpdateForm.getUserName();
        this.userNickName=userUpdateForm.getUserNickName();
        this.userPhone=userUpdateForm.getUserPhone();
        this.userEmail=userUpdateForm.getUserEmail();
        this.userIntroduction=userUpdateForm.getUserIntroduction();
        this.userPassword=userUpdateForm.getUserPassword();
        this.address=new Address(userUpdateForm.getZipCode(),userUpdateForm.getAddress(),userUpdateForm.getDetail());

        return this;
    }
}
