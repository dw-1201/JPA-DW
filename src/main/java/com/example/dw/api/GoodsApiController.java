package com.example.dw.api;

import com.example.dw.domain.dto.goods.GoodsDetailImgDto;
import com.example.dw.domain.dto.goods.GoodsListDto;
import com.example.dw.domain.dto.goods.GoodsQueDto;
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
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

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


    @GetMapping("/shopDetilImgs/{goodsId}")
    public List<GoodsDetailImgDto> findDetailImgs(@PathVariable("goodsId") Long goodsId){

        System.out.println(goodsId+"#############");
        return goodsService.goodsDetailImgs(goodsId);

    }


    @GetMapping("/shopQnaList/{goodsId}")
    public List<GoodsQueDto> findQnaList(@PathVariable("goodsId") Long goodsId){
        List<GoodsQueDto> qnaList = goodsService.goodsQnaList(goodsId);


        System.out.println(qnaList.toString());
        return qnaList;
    }


    /**
     * 쇼핑 상세 페이지
     * @return
     */
//    @GetMapping("/shopDetail/{goodsId}")
//    public List<GoodsDetailDto> shopDetail(@PathVariable("goodsId") Long goodsId, Model model){
//
//        if (goodsId == null) {
//            throw new IllegalArgumentException("존재하지 않는 게시물 번호");
//        }
//
//        List<GoodsDetailDto> result =
//                shopRepositoryCustom.findGoodsById(goodsId);
//
//        System.out.println("[상품 상세 정보] : "+result.toString());
//        model.addAttribute("goods", result.get(0));
//
//        return result;
//    }

    /**
     * 쇼핑 추가정보 페이지
     * @return
     */
//    @GetMapping("/shopAddInfo/{goodsId}")
//    public List<GoodsDetailDto> shopAddInfo(@PathVariable("goodsId") Long goodsId, Model model){
//
//        if (goodsId == null) {
//            throw new IllegalArgumentException("존재하지 않는 게시물 번호");
//        }
//
//        List<GoodsDetailDto> result =
//                shopRepositoryCustom.findGoodsById(goodsId);
//
//        System.out.println("[상품 상세 정보] : "+result.toString());
//        model.addAttribute("goods", result.get(0));
//
//        return result;
//    }

    /**
     * 쇼핑 리뷰 페이지
     */
//    @GetMapping("/shopReview/{goodsId}")
//    public List<GoodsDetailDto> shopReview(@PathVariable("goodsId") Long goodsId, Model model){
//
//        if (goodsId == null) {
//            throw new IllegalArgumentException("존재하지 않는 게시물 번호");
//        }
//
//        List<GoodsDetailDto> result =
//                shopRepositoryCustom.findGoodsById(goodsId);
//
//        System.out.println("[상품 상세 정보] : "+result.toString());
//        model.addAttribute("goods", result.get(0));
//
//        return result;
//    }

    /**
     * 쇼핑 Q and A 페이지
     * @return
     */
    @GetMapping("/shopQandA/{goodsId}")
    public List<GoodsQueDto> shopQandA(@PathVariable("goodsId") Long goodsId, Model model){

        if (goodsId == null) {
            throw new IllegalArgumentException("존재하지 않는 게시물 번호");
        }

        List<GoodsQueDto> result =
                shopRepositoryCustom.findGoodsQueId(goodsId);

        System.out.println("[상품 상세 정보] : "+result.toString());
        model.addAttribute("goods", result.get(0));

        return result;
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
     * 쇼핑 이미지 처리
     */
    @Value("${file.dir}")
    private String fileShopImg;

    @GetMapping("/shopImg")
    public byte[] getEmpImg(String fileFullPath) throws IOException {
        return FileCopyUtils.copyToByteArray(new File(fileShopImg, fileFullPath));
    }

}
