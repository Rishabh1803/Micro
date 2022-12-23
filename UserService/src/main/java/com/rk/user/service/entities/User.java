package com.rk.user.service.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "micro_users")
public class User {

    @Id
    @Column(name = "Id")
    private String userId;
    @Column(name = "Name", length = 20)
    private String name;
    @Column(name = "Email")
    private String email;
    @Column(name = "About")
    private String about;
    @Column(name = "DateOfBirth")
    private String dob;

    @Transient
    private List<Rating> ratings = new ArrayList<>();
}
