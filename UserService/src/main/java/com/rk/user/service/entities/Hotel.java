package com.rk.user.service.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Hotel {
    private String id;
    private String name;
    private String location;
    private String about;
}
