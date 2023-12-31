package com.naja.blog.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDetailsDto {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private List<String> roles;
}
