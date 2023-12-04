package com.example.dw.service;

import com.example.dw.entity.dto.GoodsCategoryForm;
import com.example.dw.entity.dto.GoodsDetailImgForm;
import com.example.dw.entity.dto.GoodsForm;
import com.example.dw.entity.dto.GoodsMainImgForm;
import com.example.dw.entity.goods.Goods;
import com.example.dw.entity.goods.GoodsDetailImg;
import com.example.dw.entity.goods.GoodsMainImg;
import com.example.dw.repository.GoodsDetailImgRepository;
import com.example.dw.repository.GoodsMainImgRepository;
import com.example.dw.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
public class FileService {


    @Value("${file.dir}")
    private String mainImg;


    private final GoodsMainImgRepository goodsMainImgRepository;
    private final GoodsDetailImgRepository goodsDetailImgRepository;
    private final GoodsRepository goodsRepository;

    //상품 메인 사진 로컬서버 저장
    @Transactional
    public GoodsMainImgForm saveImg(MultipartFile file) throws IOException {


        String originName = file.getOriginalFilename();
        UUID uuid = UUID.randomUUID();
        String sysName = uuid.toString() + "_" + originName;

        File uploadPath = new File(mainImg, getUploadPath());

        if(!uploadPath.exists()){
            uploadPath.mkdirs();
        }
        File upLoadFile = new File(uploadPath, sysName);
        file.transferTo(upLoadFile);



        return
                GoodsMainImgForm.builder()
                        .goodsMainImgName(originName)
                        .goodsMainImgUuid(uuid.toString())
                        .goodsMainImgPath(getUploadPath())
                        .build();

    }

    //상품 메인 사진 DB 저장
    @Transactional
    public void registerMainImg(MultipartFile file, Long id) throws IOException {

        //컨트롤러를 통해 받아온 id 값(상품테이블 기본키)을 가지고
        //GoodsRepository에 만들어놓은 것을 활용
        //id값을 넣어 해당 id값과 일치하는 상품을 불러오고 이것을 넣어준다.

        GoodsMainImgForm goodsMainImgForm = saveImg(file);
        Optional<Goods> goods = goodsRepository.findById(id);

        goodsMainImgForm.setGoods(goods.get());
        goodsMainImgRepository.save(goodsMainImgForm.toEntity());


    }


    //상품 상세 사진 로컬서버 저장(최대 4장)
    @Transactional
    public GoodsDetailImgForm saveDetailImg(MultipartFile file) throws IOException {


        String originName = file.getOriginalFilename();
        UUID uuid = UUID.randomUUID();
        String sysName = uuid.toString() + "_" + originName;

        File uploadPath = new File(mainImg, getUploadPath());

        if(!uploadPath.exists()){
            uploadPath.mkdirs();
        }
        File upLoadFile = new File(uploadPath, sysName);
        file.transferTo(upLoadFile);

        return
                GoodsDetailImgForm.builder()
                        .goodsDetailImgName(originName)
                        .goodsDetailImgUuid(uuid.toString())
                        .goodsDetailImgPath(getUploadPath())
                        .build();

    }

    //상품 상세 사진 DB 저장
    @Transactional
    public void registerDetailImg(List<MultipartFile> files, Long id) throws IOException {

        //파일 여러개
            for(MultipartFile file : files) {
                GoodsDetailImgForm goodsDetailImgForm = saveDetailImg(file);
                Optional<Goods> goods = goodsRepository.findById(id);

                goodsDetailImgForm.setGoods(goods.get());
                goodsDetailImgRepository.save(goodsDetailImgForm.toEntity());

            }

    }


    //경로설정
    private String getUploadPath(){
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }
    
    


}
