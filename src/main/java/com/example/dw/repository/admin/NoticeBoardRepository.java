package com.example.dw.repository.admin;

import com.example.dw.domain.entity.admin.NoticeBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NoticeBoardRepository extends JpaRepository<NoticeBoard, Long> {

    // 조회수 증가
    @Modifying
    @Query("UPDATE NoticeBoard SET noticeBoardViewCount = noticeBoardViewCount + 1 WHERE id = :noticeBoardId")
    void increaseViewCount(@Param("noticeBoardId") Long noticeBoardId);


}
