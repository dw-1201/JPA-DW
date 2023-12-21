package com.example.dw.domain.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserFileImgDto {

    private Long id;
    private String route;
    private String name;
    private String uuid;
    private Long userId;

    public UserFileImgDto(Long id, String route, String name, String uuid, Long userId) {
        this.id = id;
        this.route = route;
        this.name = name;
        this.uuid = uuid;
        this.userId = userId;
    }
}
