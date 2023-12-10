package com.example.dw.repository.user;

import com.example.dw.domain.dto.user.UserListDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsersRepositoryCustom {

    Page<UserListDto> findByAll(Pageable pageable);

}
