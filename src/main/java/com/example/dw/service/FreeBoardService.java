package com.example.dw.service;

import com.example.dw.domain.entity.freeBoard.FreeBoard;
import com.example.dw.domain.entity.user.Users;
import com.example.dw.domain.form.FreeBoardModifyForm;
import com.example.dw.domain.form.FreeBoardWritingForm;
import com.example.dw.repository.freeBoard.FreeBoardRepository;
import com.example.dw.repository.user.UsersRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FreeBoardService {

    private final FreeBoardRepository freeBoardRepository;
    private final UsersRepository usersRepository;
    private final HttpSession httpSession;
    private final FileService fileService;

    //글쓰기
    @Transactional
    public Long saveFreeBoard(FreeBoardWritingForm freeBoardWritingForm){
        // 세션에서 사용자 ID 가져오기
        Long userId = (Long) httpSession.getAttribute("userId");

        // 해당 사용자 ID로 Users 엔티티 가져오기
        Users user = usersRepository.findById(userId).orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));

        // FreeBoard 엔티티 생성 및 Users 엔티티 설정
        FreeBoard freeBoard = FreeBoard.builder()
                .freeBoardTitle(freeBoardWritingForm.getFreeBoardTitle())
                .freeBoardContent(freeBoardWritingForm.getFreeBoardContent())
                .users(user)
                .build();

        FreeBoard savedFreeBoard = freeBoardRepository.save(freeBoard);
        return savedFreeBoard.getId();
    }

    //상품 수정
    @Transactional
    public FreeBoard modify(FreeBoardModifyForm freeBoardModifyForm)
            throws IOException {

        //수정된 메인 사진이 있다면 기존 사진 삭제 후 수정된 사진으로 업데이트
//        if(!file.isEmpty()) {
//
//            //기존 사진 삭제
//            fileService.removeMainImg(goodsForm.getId());
//
//            //새로 수정된 사진 로컬 서버 저장 및 DB저장
//            fileService.registerMainImg(file, goodsForm.getId());
//        }else{
//            System.out.println("입력된 메인 사진 없음");
//        }
//
//        //상세 사진
//        if(!files.get(0).isEmpty()){
//            //기존 사진 삭제
//            fileService.removeDetailImgs(goodsForm.getId());
//
//            //새로 수정된 사진 로컬 서버 저장 및 DB저장
//            fileService.registerDetailImg(files, goodsForm.getId());
//        }


        FreeBoard freeBoard = freeBoardRepository.findById(freeBoardModifyForm.getId()).get();

        //자유게시판 기본 내용 업데이트
        freeBoard.update(freeBoardModifyForm);
        return Optional.ofNullable(freeBoard).orElseThrow(()->{
            throw new IllegalArgumentException("조회 정보 없음");
        });
    }

    //자유게시판 글삭제
    @Transactional
    public void delete(Long freeBoardId){

        if (freeBoardId == null) {

            throw new IllegalArgumentException("유효하지 않은 번호");
        }


//        fileService.removeMainImg(freeBoardId);
//        fileService.removeDetailImgs(freeBoardId);

        freeBoardRepository.deleteById(freeBoardId);


    }

}
