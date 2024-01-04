package com.example.dw.api;

import com.example.dw.domain.dto.community.WalkMateListDto;
import com.example.dw.domain.form.SearchCateLocationForm;
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
    public Page<WalkMateListDto> showWalkList(@PathVariable("page") int page,
                                              SearchCateLocationForm searchCateLocationForm){

        System.out.println("[관리자 산책글 리스트] :  "+searchCateLocationForm.toString());


        Page<WalkMateListDto> result = adminCommunityService.walkMateList(page, searchCateLocationForm);

        System.out.println(result.toString());

       return result;

    }

}
