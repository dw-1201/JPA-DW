package com.example.dw.api;


import com.example.dw.domain.dto.community.WalkMateListDto;
import com.example.dw.domain.form.SearchLocationForm;
import com.example.dw.service.WalkingMateService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/walks/*")
@RequiredArgsConstructor
public class WalkBoardApiController {


    private final WalkingMateService walkingMateService;


    //세션값 확인
    @PostMapping("/sessionOk")
    public Long checkSession(HttpSession session){

        return (Long)session.getAttribute("userId");
    }

    //산책메이트 모집글 리스트
    @GetMapping("/walkList/{page}")
    public Page<WalkMateListDto> getWalkList(@PathVariable("page") int page,
                                             SearchLocationForm searchLocationForm){

        System.out.println(searchLocationForm.toString());
        return walkingMateService.walkMateList(page, searchLocationForm);
    }



}
