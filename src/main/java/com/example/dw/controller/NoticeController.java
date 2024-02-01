package com.example.dw.controller;

import com.example.dw.domain.dto.community.FreeBoardResultDetailDto;
import com.example.dw.domain.dto.notice.NoticeDetailDto;
import com.example.dw.domain.form.FreeBoardWritingForm;
import com.example.dw.repository.admin.NoticeBoardRepository;
import com.example.dw.repository.admin.NoticeBoardRepositoryCustom;
import com.example.dw.repository.freeBoard.FreeBoardRepositoryCustom;
import com.example.dw.service.FileService;
import com.example.dw.service.FreeBoardCommentService;
import com.example.dw.service.FreeBoardService;
import com.example.dw.service.NoticeBoardService;
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
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeBoardRepositoryCustom noticeBoardRepositoryCustom;
    private final NoticeBoardRepository noticeBoardRepository;
    private final NoticeBoardService noticeBoardService;

    /**
     * 공지사항 리스트 페이지
     * @return
     */
    @GetMapping("/noticeList")
    public String notice(Model model){
        model.addAttribute("rankList",noticeBoardRepositoryCustom.findNoticeRankListById());
        return "/community/noticeList";
    }

    /**
     * 공지사항 상세 페이지
     * 페이징, 키워드 검색
     */
    @GetMapping("/noticeDetail/{noticeBoardId}")
    public String noticeDetail(@PathVariable("noticeBoardId") Long noticeBoardId, Model model,
                               HttpServletRequest request,
                               HttpServletResponse response){
        List<NoticeDetailDto> result =
                noticeBoardRepositoryCustom.findNoticeById(noticeBoardId);

        // 조회수 증가
        noticeBoardService.increaseViewCount(noticeBoardId, request, response);
        System.out.println(noticeBoardId+"noticeBoardId");

        System.out.println("[공지사항 상세 페이지] : "+result.toString());

        model.addAttribute("detail",result);

        return "/community/noticeDetail";
    }

}
