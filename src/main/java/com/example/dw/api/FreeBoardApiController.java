package com.example.dw.api;


import com.example.dw.service.FreeBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

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
