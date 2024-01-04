package com.example.dw.service;


import com.example.dw.domain.dto.goods.*;
import com.example.dw.domain.entity.goods.Cart;
import com.example.dw.domain.entity.goods.CartItem;
import com.example.dw.domain.entity.goods.GoodsQue;
import com.example.dw.domain.entity.user.Users;
import com.example.dw.domain.form.CartForm;
import com.example.dw.domain.form.CartItemForm;
import com.example.dw.domain.form.GoodsPayResultForm;
import com.example.dw.domain.form.GoodsQandaWritingForm;
import com.example.dw.repository.goods.*;
import com.example.dw.repository.user.UsersRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

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
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final GoodsPayListRepository goodsPayListRepository;
    private final GoodsPayListRepositoryCustom goodsPayListRepositoryCustom;
    private final GoodsPayListRepositoryImpl goodsPayListRepositoryImpl;


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


    //추가 정보
    @Transactional
    public Optional<GoodsAddInfoDto> goodsAddInfo(Long goodsId){
        return shopRepositoryCustom.findGoodsAddInfoById(goodsId);
    }


    //카트 번호 생성
    @Transactional
    public Long cartRegister(CartForm cartForm){
        Cart cart = cartRepository.save(cartForm.toEntity());
        return cart.getId();
    }

    //카트 번호, 카트 아이템 조회 후 분기처리
    @Transactional
    public void cartItemRegister(Long userId, CartItemForm cartItemForm){

        try {
            CartDto cartDto = shopRepositoryCustom.findCartIdByUserId(userId);

            if (cartDto == null) {
                CartForm cartForm = new CartForm();
                cartForm.setUserId(userId);
                Long newCartId = cartRegister(cartForm);
                cartItemForm.setCartId(newCartId);
            } else {
                cartItemForm.setCartId(cartDto.getId());
            }

            boolean itemExistsInCart = shopRepositoryCustom.checkGoodsId(cartItemForm.getGoodsId(), userId, cartItemForm.getCartId());

            if (itemExistsInCart) {
                CartItem cartItem = cartItemRepository.findByCartIdAndGoodsId(cartItemForm.getCartId(), cartItemForm.getGoodsId());
                cartItem.itemCount(cartItemForm);
            } else {
                cartItemRepository.save(cartItemForm.toEntity());
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }


    @Transactional//카트 아이템 제거
    public void deleteCartItem(Long cartItemId){

        cartItemRepository.deleteById(cartItemId);
    };


    /**
     * flatMap() : 리스트의 리스트가 있을 때 이를 평탄화하여 단일 리스트로 만들 수 있다.
     * @param userId
     * @return
     */
    @Transactional
    public GoodsCartListDto findCartItems(Long userId){
        CartDto cartDto = shopRepositoryCustom.findCartIdByUserId(userId);

        List<GoodsCartItemDto> cartItems = shopRepositoryCustom.findGoodsCartItemById(cartDto.getId(), userId);

        Map<GoodsCartListDto, List<CartItemDetails>> groupedItems = cartItems.stream()
                .collect(groupingBy(o -> new GoodsCartListDto(o.getCartId(), o.getUserId()),
                        mapping(o -> new CartItemDetails(
                                        o.getId(), o.getCartItemQuantity(), o.getGoodsId(), o.getGoodsName(), o.getGoodsPrice(),
                                        o.getGoodsMainImgId(), o.getGoodsMainImgName(), o.getGoodsMainImgPath(), o.getGoodsMainImgUuid()),
                                toList())));

        List<CartItemDetails> mergedItems = groupedItems.values().stream()
                .flatMap(cartItemDetails -> cartItemDetails.stream())
                .collect(Collectors.toList());
        return new GoodsCartListDto(cartDto.getId(), userId, mergedItems);
    }

    //결제페이지에 담길 물건 리스트
    @Transactional
    public void goodsPayList(List<GoodsPayListDto> goodsPayListDto, HttpSession session){

        Long userId = (Long) session.getAttribute("userId");

        try{
            List<GoodsPayDto> beforeList = goodsPayListRepository.findGoodsPayList(userId);
            System.out.println(beforeList.toString());

            //이미 상품 결제정보가 존재한다면
            if (beforeList.size() > 0) {

                for(GoodsPayDto goodsPayDtos : beforeList){

                    //개수만큼 삭제
                    goodsPayListRepository.deleteById(goodsPayDtos.getId());
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        GoodsPayResultForm goodsPayResultForm = new GoodsPayResultForm();
        //상품 결제정보 등록
       for(GoodsPayListDto goodsPlay : goodsPayListDto){
           goodsPayResultForm.setGoodsId(goodsPlay.getGoodsId());
           goodsPayResultForm.setGoodsPrice(goodsPlay.getGoodsPrice());
           goodsPayResultForm.setGoodsQuantity(goodsPlay.getGoodsQuantity());
           goodsPayResultForm.setUserId(userId);

           goodsPayListRepository.save(goodsPayResultForm.toEntity());
       }
    }


    //결제 페이지 주문내역 리스트
    @Transactional
    public List<GoodsPickListDto> goodsPickList(HttpSession session){

        Long userId = (Long) session.getAttribute("userId");

        if (userId == null) {
            throw new IllegalArgumentException("유저 정보가 없습니다.");
        }

        System.out.println("서비스");

        return goodsPayListRepositoryCustom.findGoodPayListIdByUserId(userId);
    }

}
