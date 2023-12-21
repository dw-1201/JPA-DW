package com.example.dw.api;


import com.example.dw.domain.dto.community.WalkMateListDto;
import com.example.dw.domain.form.SearchLocationForm;
import com.example.dw.service.WalkingMateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/walks/*")
@RequiredArgsConstructor
public class WalkBoardApiController {


    private final WalkingMateService walkingMateService;


    //산책메이트 모집글 리스트
    @GetMapping("/walkList/{page}")
    public Page<WalkMateListDto> getWalkList(@PathVariable("page") int page,
                                             SearchLocationForm searchLocationForm){

        System.out.println(searchLocationForm.getCity());
        System.out.println(searchLocationForm.getCounty());
        System.out.println(searchLocationForm.getState()+"##############");
        return walkingMateService.walkMateList(page, searchLocationForm);

    }

}
