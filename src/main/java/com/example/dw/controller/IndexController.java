package com.example.dw.controller;

import com.example.dw.domain.dto.community.IndexWalkMateDto;
import com.example.dw.domain.dto.goods.RecentViewGoodsDto;
import com.example.dw.service.IndexService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/index/*")
@RequiredArgsConstructor
public class IndexController {


    private final IndexService indexService;

    
    
    //Index
    @GetMapping("")
    public String index(HttpSession session, Model model){

        //산책글 리스트

        List<IndexWalkMateDto> indexWalkMateDtoList = indexService.indexWalkMateList();

        model.addAttribute("indexWalkList", indexWalkMateDtoList);
        System.out.println(indexWalkMateDtoList.toString()+"!@#@!#@!");

        
        
        //최근 본 상품
        List<RecentViewGoodsDto> recentGoods = indexService.recentViewGoods(session);

        model.addAttribute("recentGoods", recentGoods);
        

        return "/index/index";
    }




}
