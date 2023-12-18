package com.example.dw.service;

<<<<<<< HEAD
import com.example.dw.domain.dto.admin.AdminGoodsDetailImgDto;
import com.example.dw.domain.dto.admin.AdminGoodsMainImgDto;
=======
import com.example.dw.domain.dto.community.QuestionDetailDto;
import com.example.dw.domain.dto.community.QuestionImgDto;
import com.example.dw.domain.dto.goods.GoodsDetailImgDto;
import com.example.dw.domain.dto.goods.GoodsMainImgDto;
>>>>>>> project/v1
import com.example.dw.domain.entity.goods.Goods;
import com.example.dw.domain.entity.question.Question;
import com.example.dw.domain.form.GoodsDetailImgForm;
import com.example.dw.domain.form.GoodsMainImgForm;
import com.example.dw.domain.form.QuestionImgForm;
import com.example.dw.repository.community.QuestionImgRepository;
import com.example.dw.repository.community.QuestionRepository;
import com.example.dw.repository.community.QuestionRepositoryCuston;
import com.example.dw.repository.goods.GoodsDetailImgRepository;
import com.example.dw.repository.goods.GoodsMainImgRepository;
import com.example.dw.repository.goods.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class FileService {


    @Value("${file.dir}")
    private String mainImg;

    @Value("${file.que}")
    private String questionImg;


    private final GoodsMainImgRepository goodsMainImgRepository;
    private final GoodsDetailImgRepository goodsDetailImgRepository;
    private final GoodsRepository goodsRepository;

    private final QuestionRepository questionRepository;
    private final QuestionImgRepository questionImgRepository;
    private final QuestionRepositoryCuston questionRepositoryCuston;


    //상품 메인 사진 로컬서버 저장
    @Transactional
    public GoodsMainImgForm saveImg(MultipartFile file) throws IOException {


        String originName = file.getOriginalFilename();
        UUID uuid = UUID.randomUUID();
        String sysName = uuid.toString() + "_" + originName;

        File uploadPath = new File(mainImg, getUploadPath());

        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }
        File upLoadFile = new File(uploadPath, sysName);
        file.transferTo(upLoadFile);


        return
                GoodsMainImgForm.builder()
                        .goodsMainImgName(originName)
                        .goodsMainImgUuid(uuid.toString())
                        .goodsMainImgPath(getUploadPath())
                        .build();

    }

    //상품 메인 사진 DB 저장
    @Transactional
    public void registerMainImg(MultipartFile file, Long id) throws IOException {

        //컨트롤러를 통해 받아온 id 값(상품테이블 기본키)을 가지고
        //GoodsRepository에 만들어놓은 것을 활용
        //id값을 넣어 해당 id값과 일치하는 상품을 불러오고 이것을 넣어준다.

        GoodsMainImgForm goodsMainImgForm = saveImg(file);
        Optional<Goods> goods = goodsRepository.findById(id);


        goodsMainImgForm.setGoods(goods.get());
        goodsMainImgRepository.save(goodsMainImgForm.toEntity());


    }


    //상품 상세 사진 로컬서버 저장(최대 4장)
    @Transactional
    public GoodsDetailImgForm saveDetailImg(MultipartFile file) throws IOException {


        String originName = file.getOriginalFilename();
        UUID uuid = UUID.randomUUID();
        String sysName = uuid.toString() + "_" + originName;

        File uploadPath = new File(mainImg, getUploadPath());

        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }
        File upLoadFile = new File(uploadPath, sysName);
        file.transferTo(upLoadFile);

        return
                GoodsDetailImgForm.builder()
                        .goodsDetailImgName(originName)
                        .goodsDetailImgUuid(uuid.toString())
                        .goodsDetailImgPath(getUploadPath())
                        .build();

    }

    //상품 상세 사진 DB 저장
    @Transactional
    public void registerDetailImg(List<MultipartFile> files, Long id) throws IOException {

        //파일 여러개
        for (MultipartFile file : files) {
            GoodsDetailImgForm goodsDetailImgForm = saveDetailImg(file);
            Optional<Goods> goods = goodsRepository.findById(id);

            goodsDetailImgForm.setGoods(goods.get());
            goodsDetailImgRepository.save(goodsDetailImgForm.toEntity());

        }

    }


    //경로설정
    private String getUploadPath() {
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }


    //메인 사진 삭제
    @Transactional
    public void removeMainImg(Long goodsId) {
        if (goodsId == null) {
            throw new IllegalArgumentException("유효하지 않은 상품 번호");
        }

        AdminGoodsMainImgDto img = goodsMainImgRepository.findByGoodsId(goodsId).get();

        AdminGoodsMainImgDto adminGoodsMainImgDto = new AdminGoodsMainImgDto(img.getId(), img.getGoodsMainImgPath(), img.getGoodsMainImgUuid(), img.getGoodsMainImgName(), img.getGoodsId());

        File mainImgTarget = new File(mainImg, adminGoodsMainImgDto.getGoodsMainImgPath() + "/" + adminGoodsMainImgDto.getGoodsMainImgUuid() + "_" + adminGoodsMainImgDto.getGoodsMainImgName());


        if (mainImgTarget.exists()) {
            mainImgTarget.delete();

            System.out.println("[ 삭제되는 상품 메인 사진 ]" + adminGoodsMainImgDto.getGoodsMainImgPath() + "/" + adminGoodsMainImgDto.getGoodsMainImgUuid() + "_" + adminGoodsMainImgDto.getGoodsMainImgName());
            goodsMainImgRepository.deleteById(adminGoodsMainImgDto.getId());

        }

    }

    //상세 사진 삭제
    @Transactional
    public void removeDetailImgs(Long goodsId) {

        if (goodsId == null) {
            throw new IllegalArgumentException("유효하지 않은 상품 번호");
        }

        List<AdminGoodsDetailImgDto> adminGoodsDetailImgDtos = goodsDetailImgRepository.findAllByGoodsId(goodsId);


        for (AdminGoodsDetailImgDto goodsDetailImg : adminGoodsDetailImgDtos) {
            File detailImgTarget = new File(mainImg, goodsDetailImg.getGoodsDetailImgPath() + "/" + goodsDetailImg.getGoodsDetailImgUuid() + "_" + goodsDetailImg.getGoodsDetailImgName());


            if (detailImgTarget.exists()) {
                detailImgTarget.delete();

                System.out.println("[ 삭제되는 상품 상세 사진 ]" + goodsDetailImg.getGoodsDetailImgPath() + "/" + goodsDetailImg.getGoodsDetailImgUuid() + "_" + goodsDetailImg.getGoodsDetailImgName() + "\n");
                goodsDetailImgRepository.deleteById(goodsDetailImg.getId());

            }
        }

    }



    //qna 게시판 등록 파일 저장(로컬) 최대 5장
    @Transactional
    public QuestionImgForm savequestionImg(MultipartFile file) throws IOException{


        String originName = file.getOriginalFilename();
        UUID uuid = UUID.randomUUID();
        String sysName = uuid.toString() + "_" + originName;

        File uploadPath = new File(questionImg, getUploadPath());

        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }
        File upLoadFile = new File(uploadPath, sysName);
        file.transferTo(upLoadFile);

        return
                QuestionImgForm.builder()
                .questionImgName(originName)
                .questionImgRoute(getUploadPath())
                .questionImgUuid(uuid.toString())
                .build();


    }


    //que 이미지 DB 저장
    @Transactional
    public void registerquestionImg(List<MultipartFile> files, Long questionId) throws IOException {
        System.out.println("파일 처리 질문 아이기 : "+questionId);

        for (MultipartFile file : files) {
            QuestionImgForm questionImgForm= savequestionImg(file);
            Optional<Question> question = questionRepository.findById(questionId);

            questionImgForm.setQuestion(question.get());
            questionImgRepository.save(questionImgForm.toEntity());
        }

    }


    //que 기존 사진 삭제
//    public void removequeDetailImgs(Long questionId) {
//        System.out.println("파일 삭제 아이디 : " + questionId);
//        if (questionId == null) {
//            throw new IllegalArgumentException("유효하지 않은 상품 번호");
//        }
//        System.out.println(questionRepositoryCuston.findAllByQuestionId(questionId).toString() + "1-------1");
//
//        List<QuestionImgDto> questionImgDtos = questionRepositoryCuston.findAllByQuestionId(questionId);
//        System.out.println(questionImgDtos.toString()+"나는 누구이인가");
//
//        for (QuestionImgDto questionImgDto : questionImgDtos) {
//            File detailImgTarget = new File(questionImg, questionImgDto.getQuestionImgRoute() + "/" + questionImgDto.getQuestionImgUuid() + "_" + questionImgDto.getQuestionImgName());
//            System.out.println("반복문");
//            System.out.println(questionImgDto.toString()+"삭제 파일 입니다.");
//            System.out.println(detailImgTarget.toString()+"저는 파일입니다.");
//            if (detailImgTarget.exists()) {
//                detailImgTarget.delete();
//
//                System.out.println("[ 삭제 상품사진 ]" + questionImgDto.getQuestionImgRoute() + "/" + questionImgDto.getQuestionImgUuid() + "_" + questionImgDto.getQuestionImgName() + "\n");
//                questionImgRepository.deleteQuestionImgById(questionImgDto.getId());
//            }
//
//        }
//    }


}
