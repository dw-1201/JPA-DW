package com.example.dw.service;

import com.example.dw.domain.dto.community.FreeBoardCommentDto;
import com.example.dw.domain.entity.freeBoard.FreeBoardComment;
import com.example.dw.domain.form.FreeBoardCommentForm;
import com.example.dw.repository.freeBoard.FreeBoardCommentCustom;
import com.example.dw.repository.freeBoard.FreeBoardCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FreeBoardCommentService {


    private final FreeBoardCommentRepository freeBoardCommentRepository;
    private final FreeBoardCommentCustom freeBoardCommentCustom;
    //댓글등록
    public void register(FreeBoardCommentForm freeBoardCommentForm){

        freeBoardCommentRepository.save(freeBoardCommentForm.toEntity());
    }

    //특정 게시물의 댓글 목록
    public List<FreeBoardCommentDto> getList(Long freeBoardId){

        return freeBoardCommentCustom.findFreeBoardCommentsByFreeBoardId(freeBoardId);
    }

    // 댓글 수정
    public void modify(FreeBoardCommentForm freeBoardCommentForm) {
        FreeBoardComment modifyComment = freeBoardCommentRepository.findById(freeBoardCommentForm.getId())
                .orElseThrow(() -> new RuntimeException("댓글을 찾을 수 없습니다."));

        // 수정할 내용으로 엔티티 업데이트
        modifyComment.update(freeBoardCommentForm);
        // 엔티티 저장
        freeBoardCommentRepository.save(modifyComment);
    }

    // 댓글 삭제
    public void remove(Long freeBoardCommentId) {
        // FreeBoardCommentRepository에서 해당 댓글을 가져옴
        FreeBoardComment removeComment = freeBoardCommentRepository.findById(freeBoardCommentId)
                .orElseThrow(() -> new RuntimeException("댓글을 찾을 수 없습니다."));

        // 엔티티 삭제
        freeBoardCommentRepository.delete(removeComment);
    }


}
