package com.example.dw.api;


import com.example.dw.domain.dto.community.FreeBoardCommentDto;
import com.example.dw.repository.freeBoard.FreeBoardCommentCustom;
import com.example.dw.repository.freeBoard.FreeBoardCommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/replies/*")
@Slf4j
public class FreeBoardCommentApiController {

    private FreeBoardCommentRepository freeBoardCommentRepository;
    private FreeBoardCommentCustom freeBoardCommentCustom;

    @Autowired
    public void setFreeBoardCommentApiController(FreeBoardCommentRepository freeBoardCommentRepository,
                                                 FreeBoardCommentCustom freeBoardCommentCustom) {
        this.freeBoardCommentRepository = freeBoardCommentRepository;
        this.freeBoardCommentCustom = freeBoardCommentCustom;
    }

    //게시물 댓글 목록 가져오는 URL
    /**
     * @RestController: REST 방식 처리 위한 어노테이션
     * :@ResponseBody 가 포함된 어노테이션으로, JSON이나 XML 방식으로 리턴한다.
     * -> ResponseEntity<> 타입을 사용하는데, 해당 타입은 데이터뿐 아니라 상태코드도 함께 전송되는 특징이 있다.
     */
    @GetMapping(value = "/freeBoard/{freeBoardId}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FreeBoardCommentDto>> getListByFreeBoard(@PathVariable("freeBoardId") Long freeBoardId){
        log.info("freeBoardId : " + freeBoardId);

        return new ResponseEntity<>(freeBoardCommentCustom.getList(freeBoardId), HttpStatus.OK);
    }

    //댓글 데이터 전송하는 POST방식
    @PostMapping("")
    public ResponseEntity<Long> register(@RequestBody FreeBoardCommentDto freeBoardCommentDto){

        log.info("freeBoardCommentDto : {}", freeBoardCommentDto);

        Long freeBoardId = freeBoardCommentCustom.register(freeBoardCommentDto);

        return new ResponseEntity<>(freeBoardId, HttpStatus.CREATED);
    }

}
