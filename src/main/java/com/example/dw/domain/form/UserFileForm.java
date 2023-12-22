package com.example.dw.domain.form;


import com.example.dw.domain.entity.user.UserFile;
import com.example.dw.domain.entity.user.Users;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserFileForm {

    private Long id;
    private String route;
    private String name;
    private String uuid;
    private Users users;

    @Builder
    public UserFileForm(Long id, String route, String name, String uuid, Users users) {
        this.id = id;
        this.route = route;
        this.name = name;
        this.uuid = uuid;
        this.users = users;
    }

    public UserFile toEntity() {
        return UserFile.builder()
                .id(id)
                .route(route)
                .name(name)
                .uuid(uuid)
                .users(users)
                .build();
    }

}

