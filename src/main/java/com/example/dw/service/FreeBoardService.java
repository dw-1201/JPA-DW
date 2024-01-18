package com.example.dw.service;

import com.example.dw.domain.entity.freeBoard.FreeBoard;
import com.example.dw.domain.form.FreeBoardWritingForm;
import com.example.dw.repository.freeBoard.FreeBoardCommentRepository;
import com.example.dw.repository.freeBoard.FreeBoardRepository;
import com.example.dw.repository.user.UsersRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FreeBoardService {

    private final FreeBoardRepository freeBoardRepository;
    private final UsersRepository usersRepository;
    private final HttpSession httpSession;
    private final FileService fileService;
    private final FreeBoardCommentRepository freeBoardCommentRepository;

    //글쓰기
    @Transactional
    public Long register(FreeBoardWritingForm freeBoardWritingForm) throws IOException{
        FreeBoard freeBoard = freeBoardRepository.save(freeBoardWritingForm.toEntity());
        return freeBoard.getId();
    }

    //글 수정
    @Transactional
    public FreeBoard modify(FreeBoardWritingForm freeBoardWritingForm, List<MultipartFile> files)
            throws IOException {
        if (!files.get(0).isEmpty()) {

            fileService.removeFreeBoardDetailImgs(freeBoardWritingForm.getId());
            fileService.registerDBFreeBoardImg(files, freeBoardWritingForm.getId());
        }

        FreeBoard freeBoard = freeBoardRepository.findById(freeBoardWritingForm.getId()).get();
        //자유게시판 기본 내용 업데이트
        freeBoard.update(freeBoardWritingForm);

        return Optional.ofNullable(freeBoard).orElseThrow(()->{
            throw new IllegalArgumentException("조회 정보 없음");
        });
    }

    //자유게시판 글삭제
    @Transactional
    public void delete(Long freeBoardId){

        if (freeBoardId == null) {
            throw new IllegalArgumentException("존재하지 않는 자유게시판 글 번호 입니다.");
        }
        fileService.removeDetailImgs(freeBoardId);
        freeBoardRepository.deleteById(freeBoardId);
    }

    //자유게시판 조회수
    @Transactional
    public void increaseViewCount(Long freeBoarId){
        freeBoardRepository.increaseViewCount(freeBoarId);
    }

    // 게시물의 댓글 수 조회
//    public Long countCommentsByFreeBoardId(Long freeBoardId) {
//        return freeBoardCommentRepository.countCommentsByFreeBoardId(freeBoardId);
//    }

}
