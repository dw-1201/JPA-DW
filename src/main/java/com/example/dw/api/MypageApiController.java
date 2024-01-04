package com.example.dw.api;


import com.example.dw.domain.dto.community.FreeBoardDto;
import com.example.dw.domain.dto.community.QuestionListDto;
import com.example.dw.repository.admin.FaqBoardRepositoryCustom;
import com.example.dw.repository.community.QuestionRepositoryCustom;
import com.example.dw.repository.freeBoard.FreeBoardRepositoryCustom;
import com.example.dw.repository.pet.PetRepository;
import com.example.dw.service.FreeBoardService;
import com.example.dw.service.MypageService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping()
public class MypageApiController {

    private final MypageService mypageService;
    private final QuestionRepositoryCustom questionRepositoryCustom;
    private final FreeBoardRepositoryCustom freeBoardRepositoryCustom;
    private final FreeBoardService freeBoardService;

    @PostMapping("/mypgs/phone/check")
    public boolean checkPhoneDuplication(@RequestParam("userPhone") String userPhone){
        if (userPhone == null) {
            throw new IllegalArgumentException("폰 번혼 누락");

        }
        System.out.println("기입된 전화번호 : " + userPhone);
        if(mypageService.existsByUserPhone(userPhone) == true ){
            return false;
        }else {
            return true;
        }
    }

    @PostMapping("/mypgs/name/check")
    public boolean checkPetNameDuplication(@RequestParam("name") String name,
                                            @RequestParam("userId")Long userId){
        if (name == null || userId == null) {
            throw new IllegalArgumentException("누락");

        }
        System.out.println("기입된 닉네임 : " + name);
        System.out.println("조회 아이디 : "+ userId);
        if(mypageService.existsByPetName(name,userId)== true ){
            return false;
        }else {
            return true;
        }
    }


    @PostMapping("/mypgs/remove/{petId}")
    public void petInfoDelete(@PathVariable("petId") Long petId){
        System.out.println("[삭제 펫 정보 ] :" + petId);
            mypageService.removePet(petId);

        System.out.println(petId+"정보사 삭제되었습니다.");


    }

    @GetMapping("/mypgs/myWriteList/{page}/{userId}")
    public Page<QuestionListDto> findQnAList(
            @PathVariable("page") int page, @PathVariable("userId") Long userId){
        Pageable pageable = PageRequest.of(page,5);
        System.out.println(page+"페이지 번호");
        Page<QuestionListDto> result = questionRepositoryCustom.findQnaListById(pageable,userId);
        System.out.println(result.toString()+"안뇽");



        return result;

    }

    @GetMapping("/myfreeBoardList/{page}/{userId}")
    public Page<FreeBoardDto> freeBoardDtoList(
            @PathVariable("page") int page,@PathVariable("userId")Long userId) {

        Pageable pageable = PageRequest.of(page, 5);

        System.out.println("userId: " + userId);

        Page<FreeBoardDto> result = freeBoardRepositoryCustom.findFreeBoardListById(pageable,userId);

        // 댓글 수를 추가
        List<FreeBoardDto> updatedList = result.getContent().stream()
                .map(dto -> {
                    Long commentCount = freeBoardService.countCommentsByFreeBoardId(dto.getId());
                    dto.setFreeBoardCommentCount(commentCount);

                    // 댓글 수를 출력
                    System.out.println("게시물 ID: " + dto.getId() + ", 댓글 수: " + commentCount);
                    return dto;
                })
                .collect(Collectors.toList());

        System.out.println("자유게시판 글 개수 : " + result.stream().count());

        return new PageImpl<>(updatedList, pageable, result.getTotalElements());
    }

}
