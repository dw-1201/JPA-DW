package com.example.dw.domain.entity.user;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user_file")
public class UserFile {
    @Id @GeneratedValue
    @Column(name = "users_file_id")
    private Long id;

    private String route;
    private String name;
    private String uuid;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Users users;


    @Builder
    public UserFile(Long id, String route, String name, String uuid, Users users) {
        this.id = id;
        this.route = route;
        this.name = name;
        this.uuid = uuid;
        this.users = users;
    }
}
