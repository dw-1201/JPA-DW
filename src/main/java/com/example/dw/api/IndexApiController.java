package com.example.dw.api;

import com.example.dw.domain.dto.goods.IndexGoodsByCateDto;
import com.example.dw.domain.dto.index.WeeklyQnaListDto;
import com.example.dw.service.IndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/indexes/*")
@RequiredArgsConstructor
public class IndexApiController {

    @Value("${file.dir}")
    private String goodsImg;

    private final IndexService indexService;



    //시험용
    @GetMapping("/weeklyQnaBest")
    public List<WeeklyQnaListDto> weeklyQnaLists(){
        return indexService.weeklyQnaList();
    }


    //카테고리별 상품 리스트
    @GetMapping("/goodsByCate")
    public List<IndexGoodsByCateDto> goodsByCategory(String cate){

        return indexService.indexGoodsByCategory(cate);

    }

    //상품 리스트 사진
    @GetMapping("/goodsImg")
    public byte[] getEmpImg(String fileFullPath) throws IOException {
        return FileCopyUtils.copyToByteArray(new File(goodsImg, fileFullPath));
    }



}
