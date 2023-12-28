package com.example.dw.service;


import com.example.dw.domain.entity.goods.GoodsQue;
import com.example.dw.domain.entity.user.Users;
import com.example.dw.domain.form.GoodsQandaWritingForm;
import com.example.dw.repository.goods.GoodsQueRepository;
import com.example.dw.repository.goods.GoodsRepository;
import com.example.dw.repository.user.UsersRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GoodsService {

    private final HttpSession httpSession;
    private final UsersRepository usersRepository;
    private final GoodsQueRepository goodsQueRepository;
    private final GoodsRepository goodsRepository;


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

}
