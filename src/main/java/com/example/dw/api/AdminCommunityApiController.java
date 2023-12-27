package com.example.dw.api;

import com.example.dw.domain.dto.community.WalkMateListDto;
import com.example.dw.domain.form.SearchForm;
import com.example.dw.service.AdminCommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admins")
public class AdminCommunityApiController {



    private final AdminCommunityService adminCommunityService;


    @GetMapping("/walkList/{page}")
    public Page<WalkMateListDto> showWalkList(@PathVariable("page") int page, SearchForm searchForm){

        System.out.println(searchForm.toString());
        System.out.println(adminCommunityService.walkMateList(page, searchForm).toString());
       return adminCommunityService.walkMateList(page, searchForm);

    }

}
