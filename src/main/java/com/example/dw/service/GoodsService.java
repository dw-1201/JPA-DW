package com.example.dw.service;

import com.example.dw.domain.entity.goods.Goods;
import com.example.dw.domain.form.GoodsForm;
import com.example.dw.repository.goods.GoodsRepository;
import lombok.RequiredArgsConstructor;
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
public class GoodsService {



    private final GoodsRepository goodsRepository;
    private final FileService fileService;


    //상품 기본 정보 등록
    @Transactional
    public Long register(GoodsForm goodsForm) throws IOException {


        Goods goods = goodsRepository.save(goodsForm.toEntity());

        return goods.getId();
    }

    //상품 등록 유효성 검사
    @Transactional(readOnly = true)
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
    throws IOException{

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

}
