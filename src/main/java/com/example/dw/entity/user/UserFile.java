package com.example.dw.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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
}
