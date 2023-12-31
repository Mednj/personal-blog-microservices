package com.naja.userservice.service.impl;

import com.naja.userservice.dto.ProfileDto;
import com.naja.userservice.mapper.UserMapper;
import com.naja.userservice.model.User;
import com.naja.userservice.repository.UserRepository;
import com.naja.userservice.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + email));
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email).get();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void updateProfile(ProfileDto profile) {
        try {
            User user = userRepository.findByEmail(profile.getEmail()).get();
            user.setFirstName(profile.getFirstName());
            user.setLastName(profile.getLastName());
            userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ProfileDto getProfileInfo(String email) {
        return UserMapper.INSTANCE.userToProfileDto(userRepository.findByEmail(email).get());
    }
}
