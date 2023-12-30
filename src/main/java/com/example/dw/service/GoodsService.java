package com.example.dw.service;


import com.example.dw.domain.dto.goods.*;
import com.example.dw.domain.entity.goods.Cart;
import com.example.dw.domain.entity.goods.CartItem;
import com.example.dw.domain.entity.goods.GoodsQue;
import com.example.dw.domain.entity.user.Users;
import com.example.dw.domain.form.CartForm;
import com.example.dw.domain.form.CartItemForm;
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

    //카트 리스트
//    @Transactional
//    public List<GoodsCartDto> cartList(Long userId){
//        return shopRepositoryCustom.findGoodsCartById(userId);
//    }

    //카트 번호 생성
    @Transactional
    public Long cartRegister(CartForm cartForm){
        Cart cart = cartRepository.save(cartForm.toEntity());
        return cart.getId();
    }

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


    /**
     * flatMap() : 리스트의 리스트가 있을 때 이를 평탄화하여 단일 리스트로 만들 수 있다.
     * @param userId
     * @return
     */
    @Transactional
    public ShopCartListDto findCartItems(Long userId){
        CartDto cartDto = shopRepositoryCustom.findCartIdByUserId(userId);

        List<GoodsCartItemDto> cartItems = shopRepositoryCustom.findGoodsCartItemById(cartDto.getId(), userId);

        Map<ShopCartListDto, List<CartItemDetails>> groupedItems = cartItems.stream()
                .collect(groupingBy(o -> new ShopCartListDto(o.getCartId(), o.getUserId()),
                        mapping(o -> new CartItemDetails(
                                        o.getId(), o.getGoodsId(), o.getGoodsName(), o.getGoodsQuantity(), o.getGoodsPrice(),
                                        o.getGoodsMainImgId(), o.getGoodsMainImgName(), o.getGoodsMainImgPath(), o.getGoodsMainImgUuid()),
                                toList())));

        List<CartItemDetails> mergedItems = groupedItems.values().stream()
                .flatMap(cartItemDetails -> cartItemDetails.stream())
                .collect(Collectors.toList());
        return new ShopCartListDto(cartDto.getId(), userId, mergedItems);


    }

    //카트 동일 물건 수량 증가
    @Transactional
    public void increaseCartItemQuantity(Long goodsId){
        cartItemRepository.increaseCartItemQuantity(goodsId);
    }
}
