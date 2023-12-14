package com.example.dw.repository.freeBoard;

import com.example.dw.domain.dto.community.FreeBoardCommentDto;
import com.example.dw.domain.entity.freeBoard.FreeBoard;
import com.example.dw.domain.entity.freeBoard.FreeBoardComment;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class FreeBoardCommentRepositoryImpl implements FreeBoardCommentCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private FreeBoardCommentRepository freeBoardCommentRepository;

    //댓글 등록
    //저장된 댓글의 ID를 반환
    @Override
    public Long register(FreeBoardCommentDto freeBoardCommentDto) {
        FreeBoardComment freeBoardComment = dtoToEntity(freeBoardCommentDto);
        FreeBoardComment savedComment = freeBoardCommentRepository.save(freeBoardComment);
        return savedComment.getId();
    }

    //댓글 목록 조회
    //특정 게시물에 대한 댓글 목록을 조회
    //조회된 댓글 목록을 entitiesToDTOs 메서드를 사용하여 FreeBoardCommentDto 목록으로 변환
    @Override
    public List<FreeBoardCommentDto> getList(Long freeBoardId) {
        List<FreeBoardComment> comments = freeBoardCommentRepository.findAllByFreeBoardOrderByFreeBoardId(
                FreeBoard.builder().id(freeBoardId).build());
        return entitiesToDTOs(comments);
    }

    //댓글 수정
    //FreeBoardCommentDto를 FreeBoardComment 엔터티로 변환하여 저장
    //저장된 엔터티는 이미 존재하므로 수정
    @Override
    public void modify(FreeBoardCommentDto freeBoardCommentDto) {
        FreeBoardComment freeBoardComment = dtoToEntity(freeBoardCommentDto);
        freeBoardCommentRepository.save(freeBoardComment);
    }

    //댓글 삭제
    @Override
    public void remove(Long freeBoardCommentId) {
        freeBoardCommentRepository.deleteById(freeBoardCommentId);
    }

    //DTO 및 엔터티 변환 메서드
    // FreeBoardCommentDto를 FreeBoardComment 엔터티로 변환
    private FreeBoardComment dtoToEntity(FreeBoardCommentDto freeBoardCommentDto) {
        FreeBoardComment freeBoardComment = FreeBoardComment.builder()
                .id(freeBoardCommentDto.getFreeBoardCommentId())
                .freeBoardCommentContent(freeBoardCommentDto.getFreeBoardCommentContent())
                .freeBoardCommentRd(freeBoardCommentDto.getFreeBoardCommentRd())
                .freeBoardCommentMd(freeBoardCommentDto.getFreeBoardCommentMd())
                .freeBoard(FreeBoard.builder().id(freeBoardCommentDto.getFreeBoardId()).build())
                .build();
        return freeBoardComment;
    }

    // FreeBoardComment 엔터티 목록을 FreeBoardCommentDto 목록으로 변환
    private List<FreeBoardCommentDto> entitiesToDTOs(List<FreeBoardComment> freeBoardComments) {
        return freeBoardComments.stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    // FreeBoardComment 엔터티를 FreeBoardCommentDto로 변환
    private FreeBoardCommentDto entityToDTO(FreeBoardComment freeBoardComment) {
        FreeBoardCommentDto freeBoardCommentDto = FreeBoardCommentDto.builder()
                .freeBoardCommentId(freeBoardComment.getId())
                .freeBoardCommentContent(freeBoardComment.getFreeBoardCommentContent())
                .freeBoardCommentRd(freeBoardComment.getFreeBoardCommentRd())
                .freeBoardCommentMd(freeBoardComment.getFreeBoardCommentMd())
                .freeBoardId(freeBoardComment.getFreeBoard().getId())
                .build();
        return freeBoardCommentDto;
    }
}
