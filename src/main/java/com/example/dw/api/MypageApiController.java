package com.example.dw.api;


import com.example.dw.domain.dto.community.*;
import com.example.dw.domain.dto.order.OrderItemDto;
import com.example.dw.domain.dto.order.OrderListResultDto;
import com.example.dw.domain.form.SearchRecruitmentForm;
import com.example.dw.repository.community.QuestionRepositoryCustom;
import com.example.dw.repository.community.WalkingMateRepositoryCustom;
import com.example.dw.repository.community.WalkingMateStateRepository;
import com.example.dw.repository.community.WalkingMateStateRepositoryCustom;
import com.example.dw.repository.freeBoard.FreeBoardRepositoryCustom;
import com.example.dw.repository.order.OrderItemRepositoryCustom;
import com.example.dw.repository.order.OrderListRepositoryCustom;
import com.example.dw.service.FreeBoardService;
import com.example.dw.service.MypageService;
import lombok.RequiredArgsConstructor;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
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
    private final WalkingMateRepositoryCustom walkingMateRepositoryCustom;
    private final WalkingMateStateRepositoryCustom walkingMateStateRepositoryCustom;
    private final WalkingMateStateRepository walkingMateStateRepository;
    private final OrderItemRepositoryCustom orderItemRepositoryCustom;
    private final OrderListRepositoryCustom orderListRepositoryCustom;

    @Value("${file.pet}")
    private String filepetImg;

    @GetMapping("/mypgs/petImg")
    public byte[] getEmpImg(String fileFullPath) throws IOException {
        return FileCopyUtils.copyToByteArray(new File(filepetImg, fileFullPath));
    }

    @Value("${file.dir}")
    private String filegoods;

    @GetMapping("/mypgs/goods")
    public byte[] getGoodsImg(String fileFullPath) throws IOException {
        return FileCopyUtils.copyToByteArray(new File(filegoods, fileFullPath));
    }

    @PostMapping("/mypgs/phone/check")
    public boolean checkPhoneDuplication(@RequestParam("userPhone") String userPhone) {
        if (userPhone == null) {
            throw new IllegalArgumentException("폰 번혼 누락");

        }
        System.out.println("기입된 전화번호 : " + userPhone);
        if (mypageService.existsByUserPhone(userPhone) == true) {
            return false;
        } else {
            return true;
        }
    }

    @PostMapping("/mypgs/name/check")
    public boolean checkPetNameDuplication(@RequestParam("name") String name,
                                           @RequestParam("userId") Long userId) {
        if (name == null || userId == null) {
            throw new IllegalArgumentException("누락");

        }
        System.out.println("기입된 닉네임 : " + name);
        System.out.println("조회 아이디 : " + userId);
        if (mypageService.existsByPetName(name, userId) == true) {
            return false;
        } else {
            return true;
        }
    }


    @PostMapping("/mypgs/remove/{petId}")
    public void petInfoDelete(@PathVariable("petId") Long petId) {
        System.out.println("[삭제 펫 정보 ] :" + petId);
        mypageService.removePet(petId);

        System.out.println(petId + "정보사 삭제되었습니다.");


    }

    @GetMapping("/mypgs/myWriteList/{page}/{userId}")
    public Page<QuestionListDto> findQnAList(
            @PathVariable("page") int page, @PathVariable("userId") Long userId) {
        Pageable pageable = PageRequest.of(page, 5);
        System.out.println(page + "페이지 번호");
        Page<QuestionListDto> result = questionRepositoryCustom.findQnaListById(pageable, userId);
        System.out.println(result.toString() + "안뇽");


        return result;

    }

    @GetMapping("/mypgs/myfreeBoardList/{page}/{userId}")
    public Page<FreeBoardDto> freeBoardDtoList(
            @PathVariable("page") int page, @PathVariable("userId") Long userId) {

        Pageable pageable = PageRequest.of(page, 5);

        System.out.println("userId: " + userId);

        Page<FreeBoardDto> result = freeBoardRepositoryCustom.findFreeBoardListById(pageable, userId);

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
        System.out.println(updatedList + " 게시판 보여지는 곳");
        return new PageImpl<>(updatedList, pageable, result.getTotalElements());
    }

    @GetMapping("/mypgs/myregisterwalkmatewrite/{page}/{userId}")
    public Page<WalkMateMyDetailListDto> findmyregisterwalkmatewriteList(
            @PathVariable("page") int page, @PathVariable("userId") Long userId, SearchRecruitmentForm searchRecruitmentForm
    ) {
        System.out.println(page);

        Pageable pageable = PageRequest.of(page, 4);
        Page<WalkMateMyDetailListDto> result = walkingMateRepositoryCustom.findAllWalkMateAndUserId(pageable,searchRecruitmentForm, userId);
        System.out.println(result);
        return result;
    }

    @GetMapping("/mypgs/applicationwalkmate/{page}/{userId}")
    public Page<WalkMateMyApplicationListDto> findapplicationwalkmateList(
            @PathVariable("page") int page, @PathVariable("userId") Long userId,SearchRecruitmentForm searchRecruitmentForm
    ) {

        Pageable pageable = PageRequest.of(page, 4);
        Page<WalkMateMyApplicationListDto> result = walkingMateRepositoryCustom.findAllWalkMateStateAndUserId(pageable,searchRecruitmentForm ,userId);
        result.forEach(r-> System.out.println(r.getWalkingMateTitle()+"이고"+r.getWalkingMateStateId()+"입니다."));
        return result;
    }

    @PatchMapping("/mypgs/walkmatestateupdate/{walkmatestateId}")
    public Integer findapplicationwalkmateupdate(
            @PathVariable("walkmatestateId") Long walkmatestateId
    ) {
        Integer state = mypageService.walkmatestateupdate(walkmatestateId);

        System.out.println(state+ "입니다.");

        return  state;
    }

    @PatchMapping("/mypgs/walkmatestatedown/{walkmatestateId}")
    public Integer findapplicationwalkmatedown(
            @PathVariable("walkmatestateId") Long walkmatestateId
    ) {
        Integer state = mypageService.walkmatestatedown(walkmatestateId);

        System.out.println(state+ "입니다.");

        return  state;
    }

    @PatchMapping("/mypgs/walkingmatestateupdate/{walkingmateId}")
    public Long walkingmateupdate(
            @PathVariable("walkingmateId") Long walkingmateId
    ){
        Long walkingmatestate = mypageService.walkingmatestateupdate(walkingmateId);

        System.out.println(walkingmatestate+"입니다.");

        return walkingmatestate;
    }

    @GetMapping("/mypgs/orderList/{page}/{userId}")
    public Page<OrderListResultDto> orderList(@PathVariable("page") int page,@PathVariable("userId") Long userId){

        Pageable pageable =PageRequest.of(page,4);

        Page<OrderListResultDto> result = orderListRepositoryCustom.findAllbyId(pageable,userId) ;

        result.forEach(r -> System.out.println(r.getUserId()+"의 주문내역은" + r +"입니다\n"));

        return result;
    }


}
