package com.example.dw.controller;

import com.example.dw.domain.dto.community.FreeBoardResultDetailDto;
import com.example.dw.domain.form.FreeBoardWritingForm;
import com.example.dw.repository.freeBoard.FreeBoardRepositoryCustom;
import com.example.dw.service.FileService;
import com.example.dw.service.FreeBoardCommentService;
import com.example.dw.service.FreeBoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/community/*")
@RequiredArgsConstructor
public class FreeBoardController {

    private final FreeBoardService freeBoardService;
    private final FreeBoardRepositoryCustom freeBoardRepositoryCustom;
    private final FreeBoardCommentService freeBoardCommentService;  // 새로 추가
    private final HttpSession httpSession;
    private final FileService fileService;

    /**
     * 자유게시판 리스트 페이지
     * @return
     */
    @GetMapping("/freeBoardList")
    public String freeBoard(Model model){
        model.addAttribute("rankList",freeBoardRepositoryCustom.findFreeBoardRankByIdId());
        return "/community/freeBoardList";
    }

    /**
     * 자유게시판 글쓰기 페이지
     * @return
     */
    @GetMapping("/freeBoardWriting")
    public String freeBoardWriting(){
        return "/community/freeBoardWriting";
    }

    @PostMapping("/freeBoardWriting")
    public String write(FreeBoardWritingForm freeBoardWritingForm,
                        @RequestParam("freeBoardImg")List<MultipartFile> files) throws IOException{
        //파일확인
        files.forEach(r-> System.out.println("[파일목록] : "+r.getOriginalFilename()));

        // 세션에서 사용자 ID 가져오기
//        Long userId = (Long) httpSession.getAttribute("userId");
        Long id = freeBoardService.register(freeBoardWritingForm);

        System.out.println(freeBoardWritingForm.getId()+"유저 아이디");

        fileService.registerDBFreeBoardImg(files, id);
        System.out.println(files);
        System.out.println(id);
        return "redirect:/community/freeBoardList";
    }

    /**
     * 자유게시판 상세 페이지
     * @return
     */
    @GetMapping("/freeBoardDetail/{freeBoardId}")
    public String freeBoardDetail(@PathVariable("freeBoardId") Long freeBoardId, Model model,
                                  HttpServletRequest request,
                                  HttpServletResponse response){
        List<FreeBoardResultDetailDto> result =
                freeBoardRepositoryCustom.findFreeBoardById(freeBoardId);

        // 조회수 증가
        freeBoardService.increaseViewCount(freeBoardId,request,response);

        System.out.println("[자유게시판 상세 페이지] : "+result.toString());

        model.addAttribute("detail",result);

        return "community/freeBoardDetail";
    }

    /**
     * 자유게시판 수정 페이지
     * @return
     */
    @GetMapping("/modify/{freeBoardId}")
    public String freeBoardModifyPage(@PathVariable("freeBoardId") Long freeBoardId, Model model){

        List<FreeBoardResultDetailDto> result =
                freeBoardRepositoryCustom.findFreeBoardById(freeBoardId);

        model.addAttribute("freeBoard", result);

        return "/community/freeBoardModify";
    }

    /**
     * 자유게시판 수정
     * @return
     */
    @PutMapping("/modify/{freeBoardId}/edit")
    public RedirectView freeBoardModify(@PathVariable("freeBoardId") Long freeBoardId,
                                    FreeBoardWritingForm freeBoardWritingForm,
                                    @RequestParam("freeBoardImg")List<MultipartFile> files)
            throws IOException {

        freeBoardWritingForm.setId(freeBoardId);
        System.out.println("자유게시판 번호 : "+freeBoardWritingForm.getId());

        freeBoardService.modify(freeBoardWritingForm, files);

        return new RedirectView("/community/freeBoardDetail/{freeBoardId}");
//        return new RedirectView("/community/freeBoardList");
    }

    /**
     * 자유게시판 삭제
     * @return
     */
    @GetMapping("/delete/{freeBoardId}")
    public RedirectView goodsDelete(@PathVariable("freeBoardId") Long freeBoardId){

        freeBoardService.delete(freeBoardId);

        return new RedirectView("/community/freeBoardList");
    }
}
