package com.example.dw.repository.user;

import com.example.dw.domain.entity.user.UserFile;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserFileRepository extends JpaRepository<UserFile, Long> {
    void deleteById(Long id);

//    Optional<UserFileImgDto> findById(Long userId);

}
