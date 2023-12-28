package com.example.dw.api;


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
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    //관리자 상품문의 답변 등록
    @PostMapping("/addQnaReply")
    public void addQnaReply(GoodsQueReplyForm goodsQueReplyForm){


        adminGoodsService.addQnaReply(goodsQueReplyForm);

    }

    //관리자 상품문의 답변 가져오기
    @GetMapping("/replyList/{qnaId}")
    public Optional<AdminGoodsQueReplyDto> replyList(@PathVariable("qnaId") Long qnaId){

        return adminGoodsService.replyList(qnaId);

    }


    //관리자 상품문의 답변 삭제
    @DeleteMapping("/replyDelete/{replyId}")
    public void replyDelete(@PathVariable("replyId") Long replyId){




    }
}
