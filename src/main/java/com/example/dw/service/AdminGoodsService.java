package com.example.dw.service;

import com.example.dw.domain.dto.admin.AdminGoodsQnaListDto;
import com.example.dw.domain.dto.admin.AdminGoodsQueDetailDto;
import com.example.dw.domain.dto.admin.AdminGoodsQueReplyDto;
import com.example.dw.domain.dto.admin.goods.AdminGoods;
import com.example.dw.domain.dto.admin.goods.AdminGoodsReview;
import com.example.dw.domain.entity.goods.Goods;
import com.example.dw.domain.entity.goods.GoodsQue;
import com.example.dw.domain.entity.goods.GoodsQueReply;
import com.example.dw.domain.form.GoodsForm;
import com.example.dw.domain.form.GoodsQueReplyForm;
import com.example.dw.domain.form.GoodsReviewReplyForm;
import com.example.dw.domain.form.SearchReviewForm;
import com.example.dw.repository.admin.AdminGoodsRepositoryCustom;
import com.example.dw.repository.admin.AdminGoodsReviewRepository;
import com.example.dw.repository.goods.GoodsQueReplyRepository;
import com.example.dw.repository.goods.GoodsQueRepository;
import com.example.dw.repository.goods.GoodsRepository;
import com.example.dw.repository.goods.GoodsRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AdminGoodsService {

    private final AdminGoodsReviewRepository adminGoodsReviewRepository;
    private final AdminGoodsRepositoryCustom adminGoodsRepositoryCustom;
    private final GoodsQueRepository goodsQueRepository;
    private final GoodsQueReplyRepository goodsQueReplyRepository;
    private final GoodsRepositoryCustom goodsRepositoryCustom;
    private final GoodsRepository goodsRepository;
    private final FileService fileService;


    //상품 기본 정보 등록
    @Transactional
    public Long register(GoodsForm goodsForm) throws IOException {

        Goods goods = goodsRepository.save(goodsForm.toEntity());

        return goods.getId();
    }

    @Transactional
    //상품 상세 보기
    public AdminGoods.AdminGoodsDetail goodsDetail(Long goodsId){

       AdminGoods.AdminGoodsDetail lists = goodsRepositoryCustom.findGoodsById(goodsId);

        System.out.println(lists.toString()+"!!!!!!!");
        return Optional.ofNullable(lists).orElseThrow(()->{
            throw new IllegalArgumentException("조회결과 없음");
        });

    }

    //상품 등록 유효성 검사
    @Transactional
    public Map<String, String> validateHandling(Errors errors){
        Map<String, String> validatorResult = new HashMap<>();

        for(FieldError error : errors.getFieldErrors()){
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());

        }

        return validatorResult;
    }


    //상품 수정
    @Transactional
    public Goods modify(GoodsForm goodsForm, MultipartFile file, List<MultipartFile> files)
            throws IOException {

        //수정된 메인 사진이 있다면 기존 사진 삭제 후 수정된 사진으로 업데이트
        if(!file.isEmpty()) {

            //기존 사진 삭제
            fileService.removeMainImg(goodsForm.getId());

            //새로 수정된 사진 로컬 서버 저장 및 DB저장
            fileService.registerMainImg(file, goodsForm.getId());
        }else{
            System.out.println("입력된 메인 사진 없음");
        }

        //상세 사진
        if(!files.get(0).isEmpty()){
            //기존 사진 삭제
            fileService.removeDetailImgs(goodsForm.getId());

            //새로 수정된 사진 로컬 서버 저장 및 DB저장
            fileService.registerDetailImg(files, goodsForm.getId());
        }


        Goods goods = goodsRepository.findById(goodsForm.getId()).get();

        //상품 기본 내용 업데이트
        goods.update(goodsForm);
        return Optional.ofNullable(goods).orElseThrow(()->{
            throw new IllegalArgumentException("조회 정보 없음");
        });

    }


    //상품 삭제
    @Transactional
    public void delete(Long goodsId){

        if (goodsId == null) {

            throw new IllegalArgumentException("유효하지 않은 번호");
        }


        fileService.removeMainImg(goodsId);
        fileService.removeDetailImgs(goodsId);
        goodsRepository.deleteById(goodsId);


    }


    //상품문의 리스트
    @Transactional
    public Page<AdminGoodsQnaListDto> getGoodsQnaList(Pageable pageable,String qnaState, String cate, String keyword){

        Page<AdminGoodsQnaListDto> qnaList = goodsRepositoryCustom.getQnaList(pageable, qnaState, cate, keyword);

        return qnaList;
    }


    //상품문의 상세
    @Transactional
    public Optional<AdminGoodsQueDetailDto> getGoodsQnaDetail(Long qnaId){

        return goodsRepositoryCustom.getQnaDetail(qnaId);
    }


    //관리자 상품 상세 - 상품 관련 문의사항
    @Transactional
    public Page<AdminGoodsQnaListDto> findGoodsDetailQnaList(Long goodsId, Pageable pageable, String state){

       return goodsRepositoryCustom.getQnaList(goodsId, pageable, state);

    }

    //관리자 상품 상세 - 상품 관련 리뷰사항
    @Transactional
    public Page<AdminGoodsReview.AdminGoodsRelatedReview> findGoodsDetailReviewList(Long goodsId, Pageable pageable, String state){
        return goodsRepositoryCustom.getReviewList(goodsId,pageable,state);
    }



    //상품문의 답변 등록
    @Transactional
    public void addQnaReply(GoodsQueReplyForm goodsQueReplyForm){

        Optional<GoodsQue> goodsQue = goodsQueRepository.findById(goodsQueReplyForm.getGoodsQueId());

        goodsQueReplyRepository.save(goodsQueReplyForm.toEntity());
        goodsQue.get().updateStateOn();

    }

    //상품문의 답변 불러오기
    @Transactional
    public AdminGoodsQueReplyDto replyList(Long goodsQueId){

        return goodsRepositoryCustom.getReplyList(goodsQueId);

    }


    //상품문의 답변 수정
    @Transactional
    public void replyModify(GoodsQueReplyForm goodsQueReplyForm){

        GoodsQueReply goodsQueReply = goodsQueReplyRepository.findById(goodsQueReplyForm.getId()).get();
        goodsQueReply.update(goodsQueReplyForm);

    }

    //상품문의 답변 삭제
    @Transactional
    public void replyDelete(Long replyId){


        GoodsQue goodsQue = goodsQueRepository.findByGoodsQueReplyId(replyId).get();
        goodsQue.deleteState();

        goodsQueReplyRepository.deleteById(replyId);


    }


    //상품 리뷰 리스트
    @Transactional
    public Page<AdminGoodsReview.AdminGoodsReviewList.AdminGoodsReviewResultList> reviewList(Pageable pageable, SearchReviewForm searchReviewForm){

        return adminGoodsRepositoryCustom.reviewList(pageable, searchReviewForm);
    }

    //상품 리뷰 상세보기
    @Transactional
    public AdminGoodsReview.AdminGoodsReviewDetail.AdminGoodsReviewResultDetail reviewDetail(Long orderReviewId){



        return Optional.ofNullable(adminGoodsRepositoryCustom.goodsReviewDetail(orderReviewId))
                .orElseThrow(()->{throw new IllegalArgumentException("정보없음");});
    }


    //상품 리뷰 답변 등록
    @Transactional
    public void addGoodsReviewReply(GoodsReviewReplyForm goodsReviewReplyForm){

        adminGoodsReviewRepository.save(goodsReviewReplyForm.toEntity());

        adminGoodsReviewRepository.updateOrderReviewState(goodsReviewReplyForm.getOrderReviewId());

    }

    //상퓸 리뷰 답변 가져오기
    @Transactional
    public AdminGoodsReview.AdminGoodsReviewApply goodsReviewReplyList(Long orderReviewId){
        return adminGoodsRepositoryCustom.goodsReviewReplyList(orderReviewId);
    }


    //상품 리뷰 답변 삭제
    @Transactional
    public void goodsReviewReplyDelete(Long replyId, Long orderReviewId){


        adminGoodsReviewRepository.deleteOrderReviewState(orderReviewId);
        adminGoodsReviewRepository.deleteById(replyId);

    }

    //상품 리뷰 답변 수정
    @Transactional
    public void goodsReviewReplyModify(GoodsReviewReplyForm goodsReviewReplyForm){


        adminGoodsReviewRepository.updateReviewReply
                (goodsReviewReplyForm.getGoodsReviewReplyContent(),
                        goodsReviewReplyForm.getId());

    }
}
