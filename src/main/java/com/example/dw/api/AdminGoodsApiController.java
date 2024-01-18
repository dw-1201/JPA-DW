package com.example.dw.api;


import com.example.dw.domain.dto.admin.*;
import com.example.dw.domain.form.GoodsQueReplyForm;
import com.example.dw.domain.form.GoodsReviewReplyForm;
import com.example.dw.domain.form.SearchForm;
import com.example.dw.domain.form.SearchReviewForm;
import com.example.dw.repository.goods.GoodsRepositoryCustom;
import com.example.dw.service.AdminGoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admins/*")
public class AdminGoodsApiController {

    private final AdminGoodsService adminGoodsService;
    private final GoodsRepositoryCustom goodsRepositoryCustom;

    //관리자 상품 목록
    @GetMapping("/goodsList/{page}")
    public Page<AdminGoodsDto> findGoodsList(
            @PathVariable("page") int page, SearchForm searchForm){

        Pageable pageable = PageRequest.of(page, 15);
        Page<AdminGoodsDto> result = goodsRepositoryCustom.findGoodsAll(pageable, searchForm);





        return result;

    }

    //post맨 실험용
    //상품 상세 페이지 이동
    @GetMapping("/detail/{goodsId}")
    public AdminGoodsDetailResultDto goodsDetail(@PathVariable("goodsId") Long goodsId, Model model){

//        List<AdminGoodsDetailResultDto> result =
//                goodsRepositoryCustom.findGoodsById(goodsId);

//        adminGoodsService.goodsDetail(goodsId);


//        System.out.println("[상품 상세 정보] : "+result.toString());
//        model.addAttribute("detail", result);


        return adminGoodsService.goodsDetail(goodsId);


    }

    //관리자 상품 문의 목록
    @GetMapping("/goodsQnaList/{page}")
    public Page<AdminGoodsQnaListDto> findGoodsQnaList(@PathVariable("page") int page,
                                                       String qnaState,
                                                       String cate,
                                                       String keyword){

        Pageable pageable = PageRequest.of(page, 15);

        Page<AdminGoodsQnaListDto> qnaLists = adminGoodsService.getGoodsQnaList(pageable, qnaState, cate, keyword);

        return qnaLists;

    }

    //관리자 상품 상세 - 상품 관련 문의사항 리스트
    @GetMapping("/goodsRelatedQna/{goodsId}/{page}")
    public Page<AdminGoodsQnaListDto> findGoodsDetailQnaList(
            @PathVariable("goodsId") Long goodsId,
            @PathVariable("page") int page,
            String state){

        Pageable pageable = PageRequest.of(page, 10);

        return adminGoodsService.findGoodsDetailQnaList(goodsId, pageable, state);

    }

    //관리자 상품 상세 - 상품 관련 리뷰 리스트
    @GetMapping("/goodsRelatedReview/{goodsId}/{page}")
    public Page<AdminGoodsDetailReviewListDto> findGoodsDetailReviewList(
            @PathVariable("goodsId") Long goodsId,
            @PathVariable("page") int page,
            String state
    ){

        Pageable pageable = PageRequest.of(page, 10);

        return adminGoodsService.findGoodsDetailReviewList(goodsId, pageable, state);

    }




    //관리자 상품문의 답변 등록
    @PostMapping("/addQnaReply")
    public void addQnaReply(GoodsQueReplyForm goodsQueReplyForm){


        adminGoodsService.addQnaReply(goodsQueReplyForm);

    }

    //관리자 상품문의 답변 가져오기
    @GetMapping("/replyList/{qnaId}")
    public AdminGoodsQueReplyDto replyList(@PathVariable("qnaId") Long qnaId){

        return adminGoodsService.replyList(qnaId);

    }

    //관리자 상품문의 답변 수정
    @PatchMapping("/replyModify")
    public void replyModify(GoodsQueReplyForm goodsQueReplyForm){

        adminGoodsService.replyModify(goodsQueReplyForm);


    }

    //관리자 상품문의 답변 삭제
    @DeleteMapping("/replyDelete/{replyId}")
    public void replyDelete(@PathVariable("replyId") Long replyId){

        adminGoodsService.replyDelete(replyId);
    }


    //관리자 상품 리뷰 리스트
    @GetMapping("/goodsReviewList/{page}")
    public Page<AdminGoodsReviewResultDto> goodsReviewList(@PathVariable("page") int page,
                                                           SearchReviewForm searchReviewForm){

        System.out.println(searchReviewForm.toString()+"!!!");
        Pageable pageable = PageRequest.of(page, 15);

        return adminGoodsService.reviewList(pageable, searchReviewForm);

    }

    //관리자 상품 리뷰 상세(통신용)
    @GetMapping("/goodsReviewDetail/{orderReviewId}")
    public AdminGoodsReviewDetailResultDto reviewDetail(@PathVariable("orderReviewId") Long orderReviewId){
        return adminGoodsService.reviewDetail(orderReviewId);
    }
    
    //관리자 상품 리뷰 답변 등록
    @PostMapping("/addGoodsReviewReply")
    public void addGoodsReviewReply(GoodsReviewReplyForm goodsReviewReplyForm){

        System.out.println(goodsReviewReplyForm.toString()+"!#@!#!@");

        adminGoodsService.addGoodsReviewReply(goodsReviewReplyForm);

    }

    //관리자 상품 리뷰 가져오기
    @GetMapping("/goodsReviewReplyList/{orderReviewId}")
    public AdminGoodsReviewReplyDto goodsReviewReply(@PathVariable("orderReviewId")Long orderReviewId){

        return adminGoodsService.goodsReviewReplyList(orderReviewId);
    }

    //관리자 상품 리뷰 답변 삭제
    @DeleteMapping("/deleteGoodsReviewReply/{replyId}/{orderReviewId}")
    public void deleteGoodsReviewReply(@PathVariable("replyId") Long replyId,
                                       @PathVariable("orderReviewId") Long orderReviewId){

        adminGoodsService.goodsReviewReplyDelete(replyId, orderReviewId);

    }

    //관리자 상품 리뷰 답변 수정
    @PatchMapping("/modifyingGoodsReviewReply")
    public void modifyGoodsReviewReply(String modContent, Long id){
        GoodsReviewReplyForm form = new GoodsReviewReplyForm();
        form.setGoodsReviewReplyContent(modContent);
        form.setId(id);


        System.out.println(form.toString()+"!@#!@#!@#");

        adminGoodsService.goodsReviewReplyModify(form);

    }

}
