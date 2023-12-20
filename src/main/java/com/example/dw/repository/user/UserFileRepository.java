package com.example.dw.repository.user;

import com.example.dw.domain.dto.admin.AdminGoodsMainImgDto;
import com.example.dw.domain.dto.admin.UserFileDto;
import com.example.dw.domain.entity.user.UserFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserFileRepository extends JpaRepository<UserFile, Long> {
    void deleteById(Long id);

    Optional<UserFileDto> findByUserFileId(Long id);

}
