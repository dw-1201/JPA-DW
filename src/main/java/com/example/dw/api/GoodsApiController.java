package com.example.dw.api;

import com.example.dw.domain.dto.goods.*;
import com.example.dw.domain.form.*;
import com.example.dw.repository.goods.ShopRepositoryCustom;
import com.example.dw.service.GoodsService;
import jakarta.servlet.http.HttpSession;
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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
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
    public GoodsCartListDto findCartList(@PathVariable("userId") Long userId){

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


    //장바구니 정보 넣기
    @PostMapping("/cartGoods")
    public void cartGoods(@RequestBody List<GoodsPayListFrom> goodsPayListFrom, HttpSession session){

        List<GoodsPayListFrom> goodsPayList = (List<GoodsPayListFrom>)session.getAttribute("goodsPayList");

        if(goodsPayList == null){
            goodsPayList = new ArrayList<>();
        }

        for (GoodsPayListFrom goodsPayListDto : goodsPayListFrom) {
            boolean found = false;

            // goodsId를 기준으로 기존 리스트에서 아이템 찾기
            for (GoodsPayListFrom existingItem : goodsPayList) {
                if (existingItem.getGoodsId().equals(goodsPayListDto.getGoodsId())) {
                    // 기존 아이템이 존재하면 업데이트
                    existingItem.setGoodsQuantity(goodsPayListDto.getGoodsQuantity());
                    found = true;
                    break;
                }
            }

            // 기존 리스트에 해당 goodsId가 없으면 새로 추가
            if (!found) {
                goodsPayList.add(goodsPayListDto);
            }
        }

        System.out.println(goodsPayList);
        session.setAttribute("goodsPayList", goodsPayList);
    }

    //바로가기 정보 넣기
    @PostMapping("/payGoods")
    public void payGoods(@RequestBody List<GoodsPaySingleFrom> goodsPaySingleFrom, HttpSession session){

        List<GoodsPaySingleFrom> goodsPaySingle = (List<GoodsPaySingleFrom>) session.getAttribute("goodsPaySingle");

        if (goodsPaySingle == null) {
            goodsPaySingle = new ArrayList<>();
        }

        for(GoodsPaySingleFrom goodsPaySingleDto : goodsPaySingleFrom) {

            goodsPaySingle.add(goodsPaySingleDto);

        }
        System.out.println(goodsPaySingle);
        session.setAttribute("goodsPaySingle", goodsPaySingle);
    }

    //가져오기
    @GetMapping("/goodsPickList")
    public List<GoodsPayListFrom> payGoodsList(HttpSession session){
        List<GoodsPayListFrom> goodsPayListDtoList = (List<GoodsPayListFrom>) session.getAttribute("goodsPayList");

        System.out.println("총 주문내역 가져오기 : "+goodsPayListDtoList);

        return goodsPayListDtoList;
    }

    //싱글 결제 정보 가져오기
    @GetMapping("/goodsSinglePickList")
    public List<GoodsPaySingleFrom> payGoodsSingle(HttpSession httpSession) {
        List<GoodsPaySingleFrom> goodsPaySingleFrom = (List<GoodsPaySingleFrom>) httpSession.getAttribute("goodsPaySingle");

        //주문서 비우고 새로 저장
        if (goodsPaySingleFrom != null) {
            //세션삭제
            httpSession.removeAttribute("goodsPaySingle");
            System.out.println("세션삭제 후 새로 저장");
        }
        //저장 후 시간 받아오기
        for(GoodsPaySingleFrom goodsPaySingleFroms : goodsPaySingleFrom){
            goodsPaySingleFroms.setInputTime(LocalDateTime.now());
        }
        //시간 순 정렬 하기
        goodsPaySingleFrom.sort(Comparator.comparing((GoodsPaySingleFrom goodsPaySingleForm )->goodsPaySingleForm.getInputTime()).reversed());

        int max = 1;
        //리스트 배열 자르기
        if(goodsPaySingleFrom.size()>max){
            goodsPaySingleFrom=goodsPaySingleFrom.subList(0, max);
        }
        httpSession.setAttribute("goodsPaySingle", goodsPaySingleFrom);

        System.out.println("싱글 주문내역 가져오기 : "+goodsPaySingleFrom);
        return goodsPaySingleFrom;
    }
}

}
