package com.naja.blog.service;

import com.naja.blog.dto.request.PostRequest;
import com.naja.blog.dto.response.PostDetailResponse;
import com.naja.blog.dto.response.PostListResponse;
import com.naja.blog.dto.response.PostNumberInCategory;
import com.naja.blog.model.Post;

import java.util.List;

public interface PostService {
    PostRequest save(PostRequest post);
    List<PostListResponse> getAll();
    PostDetailResponse getPostDetail(Long id);
    Post getById(Long postId);
    List<PostNumberInCategory> postCategoryCount();
}
