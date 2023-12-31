package com.naja.blog.service;

import com.naja.blog.dto.UserDetailsDto;
import com.naja.blog.model.User;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceClient {

    private String authServiceBaseUrl = "http://localhost:8081";

    private final RestTemplate restTemplate;

    @Autowired
    public UserServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDetailsDto getUserDetails(String userEmail) {
        String url = authServiceBaseUrl + "/api/auth/user-details?email=" + userEmail;
        return restTemplate.getForObject(url, UserDetailsDto.class);
    }


}
