package com.example.dw.repository.community;



import com.example.dw.domain.dto.community.QuestionImgDto;
import com.example.dw.domain.entity.question.QuestionImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionImgRepository extends JpaRepository<QuestionImg,Long> {
    void deleteQuestionImgById(Long id);

    // question id로 이미지 찾기 , 디테일 페이지에서 찾아오기
    List<QuestionImgDto> findByQuestionImg(Long id);


}
