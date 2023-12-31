package com.naja.blog.service;

import com.naja.blog.dto.request.CommentRequest;
import com.naja.blog.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllCommentByPostId(Long id);
    void save(CommentRequest comment);
}
