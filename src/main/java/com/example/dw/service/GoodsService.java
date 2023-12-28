package com.example.dw.service;


import com.example.dw.domain.dto.goods.GoodsDetailDto;
import com.example.dw.domain.dto.goods.GoodsDetailImgDto;
import com.example.dw.domain.dto.goods.GoodsQueDto;
import com.example.dw.domain.entity.goods.GoodsQue;
import com.example.dw.domain.entity.user.Users;
import com.example.dw.domain.form.GoodsQandaWritingForm;
import com.example.dw.repository.goods.GoodsMainImgRepository;
import com.example.dw.repository.goods.GoodsQueRepository;
import com.example.dw.repository.goods.GoodsRepository;
import com.example.dw.repository.goods.ShopRepositoryCustom;
import com.example.dw.repository.user.UsersRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GoodsService {

    private final HttpSession httpSession;
    private final UsersRepository usersRepository;
    private final GoodsQueRepository goodsQueRepository;
    private final GoodsRepository goodsRepository;
    private final ShopRepositoryCustom shopRepositoryCustom;
    private final GoodsMainImgRepository goodsMainImgRepository;


    //모달 글쓰기
    @Transactional
    public Long writeModal(GoodsQandaWritingForm goodsQandaWritingForm){
        // 세션에서 사용자 ID 가져오기
        Long userId = (Long) httpSession.getAttribute("userId");

        // 해당 사용자 ID로 Users 엔티티 가져오기
        Users user = usersRepository.findById(userId).orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));

        // GoodsQue 엔티티 생성 시 queContent 설정
        GoodsQue savedGoodsQue = goodsQueRepository.save(
                GoodsQue.builder()
                        .queContent(goodsQandaWritingForm.getQueContent())
                        .users(user)
                        .goods(goodsRepository.findById(goodsQandaWritingForm.getGoodsId())
                                .orElseThrow(() -> new RuntimeException("상품을 찾을 수 없습니다.")))
                        .build());

        return savedGoodsQue.getId();
    }

    //상품 상세 정보
    @Transactional
    public Optional<GoodsDetailDto> goodsDetail(Long goodsId){

        return shopRepositoryCustom.findGoodsById(goodsId);
    }


    //상품 상세 상세사진
    @Transactional
    public List<GoodsDetailImgDto> goodsDetailImgs(Long goodsId){

        return shopRepositoryCustom.findGoodsDetailImg(goodsId);

    }


    //상품 문의 리스트
    @Transactional
    public List<GoodsQueDto> goodsQnaList(Long goodsId){

        return shopRepositoryCustom.findGoodsQueId(goodsId);

    }

}
