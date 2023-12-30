package com.example.dw.controller;

import com.example.dw.domain.dto.admin.AdminGoodsDetailResultDto;
import com.example.dw.domain.dto.admin.AdminGoodsQueDetailDto;
import com.example.dw.domain.form.GoodsForm;
import com.example.dw.repository.goods.GoodsRepositoryCustom;
import com.example.dw.service.AdminGoodsService;
import com.example.dw.service.FileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/*")

public class AdminGoodsController {

    private final AdminGoodsService adminGoodsService;
    private final FileService fileService;
    private final GoodsRepositoryCustom goodsRepositoryCustom;

    //상품리스트
    @GetMapping("/goodsList")
    public String GoodsList(){
        return "/admin/adminGoodsList";
    }

    //상품등록 페이지 이동
    @GetMapping("/goodsReg")
    public String goodsRegister(){
        return "/admin/adminGoodsReg";
    }

    //상품 등록
    @PostMapping("/goodsRegister")
    public String goodsRegister(@Valid GoodsForm goodsForm,
                                @RequestParam("goodsMainImg") MultipartFile file,   //메인사진
                                @RequestParam("goodsDetailImg") List<MultipartFile> files //상세사진
//                                    , BindingResult bindingResult, Model model
//
    ) throws IOException {

//        if(bindingResult.hasErrors()){
//            model.addAttribute("error", goodsForm);
//
//
//            Map<String, String> validatorResult = goodsService.validateHandling(bindingResult);
//            for(String key : validatorResult.keySet()){
//                model.addAttribute(key, validatorResult.get(key));
//            }
//
//            return "/goods/adminGoodsReg";
//        }

        //해당 컨트롤러로 타고 들어오는 정보 내용
        System.out.println("[상품 등록 정보 ] : " + goodsForm.toString());
        System.out.println("[상품 메인 사진 정보] : " + file.getOriginalFilename());
        files.forEach(r-> System.out.println("[상품 상세 사진 정보] : " + r.getOriginalFilename()));


        //상품 기본 정보 등록
        //등록 시 반환되는 goods_id값을 이용하여 사진 등록 메소드의 매개변수로 사용
        Long id = adminGoodsService.register(goodsForm);

        fileService.registerMainImg(file, id);      //메인사진
        fileService.registerDetailImg(files, id);   //상세사진

        return ("redirect:/admin/goodsList");
    }

    //상품 상세 페이지 이동
    @GetMapping("/detail/{goodsId}")
    public String goodsDetail(@PathVariable("goodsId") Long goodsId, Model model){

        List<AdminGoodsDetailResultDto> result =
                goodsRepositoryCustom.findGoodsById(goodsId);



        System.out.println("[상품 상세 정보] : "+result.toString());
        model.addAttribute("detail", result);


        return "/admin/adminGoodsDetail";

    }

    //상품 수정 페이지 이동
    @GetMapping("/modify/{goodsId}")
    public String goodsModifyPage(@PathVariable("goodsId") Long goodsId, Model model){

        List<AdminGoodsDetailResultDto> result =
                goodsRepositoryCustom.findGoodsById(goodsId);

        model.addAttribute("detail", result);

        return "/admin/adminGoodsModify";
    }

    //상품 수정
    @PutMapping("/modify/{goodsId}/edit")
    public RedirectView goodsModify(@PathVariable("goodsId") Long goodsId,
                                    GoodsForm goodsForm,
                                    @RequestParam("goodsMainImg") MultipartFile file,
                                    @RequestParam("goodsDetailImg") List<MultipartFile> files) throws IOException {

        goodsForm.setId(goodsId);
        System.out.println("받아오는 상품번호 : "+goodsForm.getId());


        adminGoodsService.modify(goodsForm,file,files);

        return new RedirectView("/admin/detail/" + goodsId);
    }


    //상품 삭제
    @GetMapping("/delete/{goodsId}")
    public RedirectView goodsDelete(@PathVariable("goodsId") Long goodsId){


        adminGoodsService.delete(goodsId);

        return new RedirectView("/admin/goodsList");
    }


    @GetMapping("/goodsQna")
    public String goodsQna(){
        return "admin/adminGoodsQue";
    }

    @GetMapping("/goodsReview")
    public String goodsReview(){
        return "admin/adminGoodsReview";
    }




    //상품 문의 상세보기
    @GetMapping("/qnaDetail/{qnaId}")
    public String qnaDetail(@PathVariable("qnaId") Long qnaId,
                            Model model){

        Optional<AdminGoodsQueDetailDto> detail = adminGoodsService.getGoodsQnaDetail(qnaId);

        System.out.println(detail.get().toString());

        detail.ifPresent(details -> model.addAttribute("details", details));


        return "/admin/adminGoodsQueDetail";

    }

}
