//package com.example.dw.domain.entity.user;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Commit;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDateTime;
//
//@SpringBootTest
//@Transactional
//@Commit
//class UsersTest {
//    @PersistenceContext
//    private EntityManager em;
//
//
//
//    @Test
//    void test1() {
//        Users users = new Users();
//        Address address = new Address();
//        Pet pet = new Pet();
//        PetImg petImg = new PetImg();
//        UserFile userFile = new UserFile();
//        PetCategory petCategory = new PetCategory();
//
//
//        userFile.setName("iii");
//        userFile.setRoute("uuu");
//        userFile.setUuid("qqqq");
//
//
//        address.setZipCode("123");
//        address.setAddress("123");
//        address.setDetail("123");
//
//        users.setUserAccount("id");
//        users.setUserName("name");
//        users.setUserPassword("1234");
//        users.setUserPhone("01012341234");
//        users.setUserEmail("123@naver.cpm");
//        users.setUserIntroduction("1111");
//        users.setUserNickName("1234");
//        users.setUserJoinDate(LocalDateTime.now());
//        users.setAddress(address);
//        userFile.setUsers(users);
//        em.persist(users);
//        em.persist(userFile);
//
//        petCategory.setCategoryName("얌야먀얌");
//        em.persist(petCategory);
//
//        pet.setPetCategory(petCategory);
//        pet.setPetGender("Y");
//        pet.setName("dd");
//        pet.setBirthDate("2022");
////        pet.setNeutering("y");
//        pet.setWeight(59L);
//        pet.setUsers(users);
//        em.persist(pet);
//
//        petImg.setPetUuid("ddd");
//        petImg.setPetPath("oooo");
//        petImg.setPetFileName("3333");
//        pet.setPetImg(petImg);
//        petImg.setPet(pet);
//        em.persist(petImg);
//
//
//
//    }
//}