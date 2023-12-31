package com.naja.blog.controller;

import com.naja.blog.dto.UserDetailsDto;
import com.naja.blog.dto.request.PostRequest;
import com.naja.blog.dto.response.MessageResponse;
import com.naja.blog.dto.response.PostDetailResponse;
import com.naja.blog.dto.response.PostListResponse;
import com.naja.blog.dto.response.PostNumberInCategory;
import com.naja.blog.service.PostService;
import com.naja.blog.service.UserServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/api/posts")
@Validated
public class PostController {
    private final PostService postService;
    private final UserServiceClient userServiceClient;

    @Autowired
    public PostController(PostService postService, UserServiceClient userServiceClient) {
        this.postService = postService;
        this.userServiceClient = userServiceClient;
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<?> addPost(@Valid @RequestBody PostRequest postRequest) {
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        postRequest.setUserEmail(userEmail);
        postService.save(postRequest);
        return ResponseEntity.ok(new MessageResponse("Post created successfully"));
    }

    @GetMapping
    public ResponseEntity<List<PostListResponse>> getAll() {
        return ResponseEntity.ok(postService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDetailResponse> getPost(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPostDetail(id));
    }

    @GetMapping("/count-by-category")
    public ResponseEntity<List<PostNumberInCategory>> postNumberInCategory() {
        return ResponseEntity.ok(this.postService.postCategoryCount());
    }

    @GetMapping("/user-details")
    public ResponseEntity<UserDetailsDto> getUserDetails(@RequestParam String userEmail) {
        UserDetailsDto userDetails = userServiceClient.getUserDetails(userEmail);
        return ResponseEntity.ok(userDetails);
    }
}
