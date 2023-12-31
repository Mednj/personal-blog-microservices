package com.naja.userservice.service;

import com.naja.userservice.dto.ProfileDto;
import com.naja.userservice.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    boolean existsByEmail(String email);
    User getByEmail(String email);
    User save(User user);
    void updateProfile(ProfileDto profile);
    ProfileDto getProfileInfo(String email);
}
