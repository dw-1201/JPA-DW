package com.example.dw.api;

import com.example.dw.domain.dto.goods.IndexGoodsByCateDto;
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




    @GetMapping("/goodsByCate")
    public List<IndexGoodsByCateDto> goodsByCategory(String cate){

        return indexService.indexGoodsByCategory(cate);

    }

    @GetMapping("/goodsImg")
    public byte[] getEmpImg(String fileFullPath) throws IOException {
        return FileCopyUtils.copyToByteArray(new File(goodsImg, fileFullPath));
    }



}
