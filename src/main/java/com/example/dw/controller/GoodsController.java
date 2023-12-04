package com.example.dw.controller;

import com.example.dw.domain.form.GoodsCategoryForm;
import com.example.dw.domain.form.GoodsForm;
import com.example.dw.service.FileService;
import com.example.dw.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/goods")
public class GoodsController {


    private final GoodsService goodsService;
    private final FileService fileService;


    //상품 등록
    @PostMapping("/register")
    public String goodsRegister(GoodsCategoryForm goodsCategoryForm, GoodsForm goodsForm,
                            @RequestParam("goodsMainImg") MultipartFile file,   //메인사진
                            @RequestParam("goodsDetailImg") List<MultipartFile> files //상세사진
    ) throws IOException {

        //해당 컨트롤러로 타고 들어오는 정보 내용
        System.out.println("[상품 등록 정보 ] : " + goodsForm.toString());
        System.out.println("[상품 메인 사진 정보] : " + file.getOriginalFilename());
        files.forEach(r-> System.out.println("[상품 상세 사진 정보] : " + r.getOriginalFilename()));


        //상품 기본 정보 등록
        //등록 시 반환되는 goods_id값을 이용하여 사진 등록 메소드의 매개변수로 사용
        Long id = goodsService.register(goodsForm, goodsCategoryForm);

        fileService.registerMainImg(file, id);      //메인사진
        fileService.registerDetailImg(files, id);   //상세사진


        return "/admin/adminGoodsList";
    }


}
