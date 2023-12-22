package com.example.dw.service;


import com.example.dw.domain.entity.goods.Goods;
import com.example.dw.domain.entity.user.Pet;
import com.example.dw.domain.entity.user.Users;
import com.example.dw.domain.form.GoodsForm;
import com.example.dw.domain.form.PetForm;
import com.example.dw.domain.form.UserUpdateForm;
import com.example.dw.repository.pet.PetRepository;
import com.example.dw.repository.user.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MypageService {

    private final FileService fileService;
    private final UsersRepository usersRepository;
    private final PetRepository petRepository;


    //회원정보 수정
    @Transactional
    public Users modify(UserUpdateForm userUpdateForm, MultipartFile file)
            throws IOException {
        System.out.println(userUpdateForm+"내용입니다");
        System.out.println(file+"적용되는 사진입니다");
        //수정된 메인 사진이 있다면 기존 사진 삭제 후 수정된 사진으로 업데이트
        System.out.println(!file.isEmpty());
        if(!file.isEmpty()) {
            System.out.println("사진 저장");
            //기존 사진 삭제
            fileService.removeUserImg(userUpdateForm.getId());

            //새로 수정된 사진 로컬 서버 저장 및 DB저장
            fileService.registerUserImg(file, userUpdateForm.getId());
        }else{
            System.out.println("입력된 메인 사진 없음");
        }



        Users users = usersRepository.findById(userUpdateForm.getId()).get();

        //상품 기본 내용 업데이트
        users.update(userUpdateForm);
        System.out.println(users+toString()+"수정입니다.");
        return Optional.ofNullable(users).orElseThrow(()->{
            throw new IllegalArgumentException("조회 정보 없음");
        });

    }

    //휴대폰 번호 중복체크
    @Transactional(readOnly = true)
    public boolean existsByUserPhone(String userPhone){
        return usersRepository.existsByUserPhone(userPhone);
    }

    //휴대폰 번호 중복체크
    @Transactional(readOnly = true)
    public boolean existsByUserNicName(String userNickName){
        return usersRepository.existsByUserNickName(userNickName);
    }

    @Transactional
    public Long register(PetForm petForm)throws IOException{
        System.out.println(petForm.toEntity()+"입니다.");

        Pet pet = petRepository.save(petForm.toEntity());

        System.out.println(pet.getUsers().getId()+"유저의 반려묘" + pet.getName()+"입니다.");

        return pet.getId();

    }


}
