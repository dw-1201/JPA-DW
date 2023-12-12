package com.example.dw.domain.entity.admin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Commit
class AdminTest {
    @PersistenceContext
    private EntityManager em;



//    @Test
//    void test1() {
//        Admin admin = new Admin();
//        admin.setAdminAccount("abc123");
//        admin.setAdminPassword("1234");
//        em.persist(admin);
//    }
}