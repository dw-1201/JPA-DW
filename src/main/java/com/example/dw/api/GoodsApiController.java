package com.example.dw.api;

import com.example.dw.domain.dto.goods.*;
import com.example.dw.domain.form.CartItemForm;
import com.example.dw.domain.form.GoodsQandaWritingForm;
import com.example.dw.domain.form.SearchForm;
import com.example.dw.repository.goods.ShopRepositoryCustom;
import com.example.dw.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shops/*")
public class GoodsApiController {

    private final ShopRepositoryCustom shopRepositoryCustom;
    private final GoodsService goodsService;

    /**
     * 쇼핑 리스트 페이지
     */
    @GetMapping("/shopList/{page}")
    public Page<GoodsListDto> findShopList(
            @PathVariable("page") int page, SearchForm searchForm){

        Pageable pageable = PageRequest.of(page,12);
        Page<GoodsListDto> result = shopRepositoryCustom.findGoodsListAll(pageable, searchForm);
        System.out.println(result.toString()+"############");
        return result;
    }

    /**
     * 쇼핑 설명 페이지(이미지)
     * @return
     */
    @GetMapping("/shopDetilImgs/{goodsId}")
    public List<GoodsDetailImgDto> findDetailImgs(@PathVariable("goodsId") Long goodsId){

        System.out.println(goodsId+"#############");
        return goodsService.goodsDetailImgs(goodsId);
    }

    /**
     * 쇼핑 추가정보 페이지
     * @return
     */
    @GetMapping("/shopAddInfo/{goodsId}")
    public Optional<GoodsAddInfoDto> findAddInfo(@PathVariable("goodsId") Long goodsId) {
        Optional<GoodsAddInfoDto> detail = goodsService.goodsAddInfo(goodsId);

        System.out.println(detail.toString());
        return detail;
    }

    /**
     * 쇼핑 리뷰 페이지
     */


    /**
     * 쇼핑 Q and A 페이지
     * @return
     */
    @GetMapping("/shopQnaList/{goodsId}")
    public List<GoodsQueDto> findQnaList(@PathVariable("goodsId") Long goodsId){
        List<GoodsQueDto> qnaList = goodsService.goodsQnaList(goodsId);


        System.out.println(qnaList.toString());
        return qnaList;
    }

    // 쇼핑 Q and A 페이지 모달 창으로 문의 글 작성하기
    @PostMapping("/shopQandaWriteModal")
    public ResponseEntity<Long> shopQandaWriteModal(GoodsQandaWritingForm goodsQandaWritingForm) {
        try {
            // goodsService를 사용하여 문의 글을 작성하고 저장하고 그에 대한 ID를 반환
            Long savedGoodsQueId = goodsService.writeModal(goodsQandaWritingForm);

            // 성공적으로 처리된 경우 해당 ID와 HTTP 상태코드 201(CREATED)를 응답
            return new ResponseEntity<>(savedGoodsQueId, HttpStatus.CREATED);
        } catch (Exception e) {
            // 예외가 발생한 경우 내부 서버 오류(HTTP 상태코드 500)를 응답
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 쇼핑 카트 페이지
     */
    @GetMapping("/shopCart/{userId}")
    public void findCartList(@PathVariable("userId") Long userId,
                                           CartItemForm cartItemForm){

        System.out.println("api goodsid" + cartItemForm.getGoodsId());
        System.out.println("api cartid" + cartItemForm.getCartId());

        goodsService.cartItemRegister(userId, cartItemForm);
    }

    //카트에 물건 담기
    @GetMapping("/shopCartList/{userId}")
    public ShopCartListDto findCartList(@PathVariable("userId") Long userId){

       return goodsService.findCartItems(userId);
    }

    //카트 물건 삭제
    @GetMapping("/delete/{cartItemId}")
    public void deleteCartItem(@PathVariable("cartItemId")Long cartItemId){

        goodsService.deleteCartItem(cartItemId);

    }


    /**
     * 쇼핑 이미지 처리
     */
    @Value("${file.dir}")
    private String fileShopImg;

    @GetMapping("/shopImg")
    public byte[] getEmpImg(String fileFullPath) throws IOException {
        return FileCopyUtils.copyToByteArray(new File(fileShopImg, fileFullPath));
    }

}
