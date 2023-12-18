package com.example.dw.api;


import com.example.dw.domain.dto.community.FreeBoardCommentDto;
import com.example.dw.domain.form.FreeBoardCommentForm;
import com.example.dw.repository.freeBoard.FreeBoardCommentRepository;
import com.example.dw.repository.user.UsersRepository;
import com.example.dw.service.FreeBoardCommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/replies/*")
@Slf4j
public class FreeBoardCommentApiController {

    private final FreeBoardCommentRepository freeBoardCommentRepository;
    private final UsersRepository usersRepository;
    private final FreeBoardCommentService freeBoardCommentService;

    //댓글 데이터 전송하는 POST방식
    @PostMapping("/writeComment")
    public void register(@RequestBody FreeBoardCommentForm freeBoardCommentForm) {

                freeBoardCommentService.register(freeBoardCommentForm);

    }
    //댓글 불러오기
    @GetMapping("/readComment/{freeBoardId}")
    public List<FreeBoardCommentDto> showReplyList(@PathVariable("freeBoardId") Long freeBoardId){

        if (freeBoardId == null) {
            throw new IllegalArgumentException("존재하지 않는 게시물 번호");
        }
        System.out.println(freeBoardCommentService.getList(freeBoardId).toString());
      return freeBoardCommentService.getList(freeBoardId);
    }

    // 댓글 수정
    @PatchMapping("/modifyComment/{freeBoardCommentId}")
    public void modify(@RequestBody FreeBoardCommentForm freeBoardCommentForm) {
        System.out.println(freeBoardCommentForm.getFreeBoardCommentContent());
        System.out.println(freeBoardCommentForm.getId());
        freeBoardCommentService.modify(freeBoardCommentForm);
    }

    //댓글 삭제하기
    @DeleteMapping("/deleteComment/{freeBoardCommentId}")
    public void delete(@PathVariable Long freeBoardCommentId) {
        freeBoardCommentService.remove(freeBoardCommentId);
    }
}
