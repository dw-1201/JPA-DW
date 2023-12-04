package com.example.dw.api;


import com.example.dw.entity.dto.freeBoardDto.FreeBoardDto;
import com.example.dw.entity.freeBoard.FreeBoard;
import com.example.dw.repository.FreeBoardRepository;
import com.example.dw.service.FreeBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FreeBoardApiController {

    private FreeBoardService freeBoardService;

//    @GetMapping("/api/freeBaords")
//    public List<FreeBoardDto> freeBoardDtoList(){
//        List<FreeBoard> freeBoardList = freeBoardService.getFreeBoardList();
//        return freeBoardList
//    }
}
