package com.example.dw.api;


import com.example.dw.domain.dto.admin.AdminGoodsDetailResultDto;
import com.example.dw.domain.dto.admin.AdminGoodsDto;
import com.example.dw.domain.dto.admin.AdminGoodsQnaListDto;
import com.example.dw.domain.dto.admin.AdminGoodsQueReplyDto;
import com.example.dw.domain.form.GoodsQueReplyForm;
import com.example.dw.domain.form.SearchForm;
import com.example.dw.repository.goods.GoodsRepositoryCustom;
import com.example.dw.service.AdminGoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

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


        //해당 날짜가 껴있는 전주 날짜 구하기
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime lastWeekStart = now.minusWeeks(1).with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).toLocalDate().atStartOfDay();
        LocalDateTime lastWeekEnd = now.minusWeeks(1).with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).toLocalDate().atTime(23, 59, 59);

        System.out.println("Last week's start date: " + lastWeekStart);
        System.out.println("Last week's end date: " + lastWeekEnd);


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



}
