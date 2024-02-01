package com.example.dw.service;

import com.example.dw.domain.entity.freeBoard.FreeBoard;
import com.example.dw.domain.form.FreeBoardWritingForm;
import com.example.dw.repository.freeBoard.FreeBoardCommentRepository;
import com.example.dw.repository.freeBoard.FreeBoardRepository;
import com.example.dw.repository.user.UsersRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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

    private final static String VIEWCOOKIENAME = "alreadyViewCookie";

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
    public int increaseViewCount(Long freeBoarId, HttpServletRequest request, HttpServletResponse response){

        Cookie[] cookies = request.getCookies();
        boolean checkCookie = false;
        int result = 0;
        if(cookies != null){
            for (Cookie cookie : cookies)
            {
                // 이미 조회를 한 경우 체크
                if (cookie.getName().equals(VIEWCOOKIENAME+freeBoarId)) checkCookie = true;
            }
            if(!checkCookie){
                Cookie newCookie = createCookieForForNotOverlap(freeBoarId);
                response.addCookie(newCookie);
                result = freeBoardRepository.increaseViewCount(freeBoarId);
            }
        } else {
            Cookie newCookie = createCookieForForNotOverlap(freeBoarId);
            response.addCookie(newCookie);
            result = freeBoardRepository.increaseViewCount(freeBoarId);
        }
        return result;
    }

    /*
     * 조회수 중복 방지를 위한 쿠키 생성 메소드
     * @param cookie
     * @return
     * */
    private Cookie createCookieForForNotOverlap(Long postId) {
        Cookie cookie = new Cookie(VIEWCOOKIENAME+postId, String.valueOf(postId));
        cookie.setComment("조회수 중복 증가 방지 쿠키");	// 쿠키 용도 설명 기재
        cookie.setMaxAge(getRemainSecondForTommorow()); 	// 하루를 준다.
        cookie.setHttpOnly(true);				// 서버에서만 조작 가능
        return cookie;
    }

    // 다음 날 정각까지 남은 시간(초)
    private int getRemainSecondForTommorow() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tommorow = LocalDateTime.now().plusDays(1L).truncatedTo(ChronoUnit.DAYS);
        return (int) now.until(tommorow, ChronoUnit.SECONDS);
    }
}
