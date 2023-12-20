package com.example.dw.service;


import com.example.dw.domain.entity.goods.Goods;
import com.example.dw.domain.entity.user.Users;
import com.example.dw.domain.form.GoodsForm;
import com.example.dw.domain.form.UserUpdateForm;
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


    //회원정보 수정
    @Transactional
    public Users modify(UserUpdateForm userUpdateForm, MultipartFile file)
            throws IOException {

        //수정된 메인 사진이 있다면 기존 사진 삭제 후 수정된 사진으로 업데이트
        if(!file.isEmpty()) {

            //기존 사진 삭제
            fileService.removeMainImg(goodsForm.getId());

            //새로 수정된 사진 로컬 서버 저장 및 DB저장
            fileService.registerMainImg(file, goodsForm.getId());
        }else{
            System.out.println("입력된 메인 사진 없음");
        }



        Users users = usersRepository.findById(userUpdateForm.getId()).get();

        //상품 기본 내용 업데이트
        goods.update(goodsForm);
        return Optional.ofNullable(goods).orElseThrow(()->{
            throw new IllegalArgumentException("조회 정보 없음");
        });

    }



}
