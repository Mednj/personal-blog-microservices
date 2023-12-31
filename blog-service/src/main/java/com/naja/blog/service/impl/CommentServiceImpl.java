package com.naja.blog.service.impl;
import com.naja.blog.dto.UserDetailsDto;
import com.naja.blog.dto.request.CommentRequest;
import com.naja.blog.model.Comment;
import com.naja.blog.repository.CommentRepository;
import com.naja.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import com.naja.blog.service.UserServiceClient;


@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final UserServiceClient userServiceClient;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, UserServiceClient userServiceClient) {
        this.commentRepository = commentRepository;
        this.userServiceClient = userServiceClient;
    }

    @Override
    public List<Comment> getAllCommentByPostId(Long id) {
        return commentRepository.findByPost_Id(id);
    }

    @Override
    public void save(CommentRequest commentRequest) {
        try {
            // Make a call to the user service to get user information
            UserDetailsDto userDetailsDto = userServiceClient.getUserDetails(commentRequest.getUserEmail());

            Comment comment = new Comment();
            comment.setComment(commentRequest.getComment());
            comment.setCreatedAt(LocalDateTime.now());
            comment.setUser(userServiceClient.userDtoToUser(userDetailsDto));
            comment.setPost(postService.getById(commentRequest.getPostId()));
            commentRepository.save(comment);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
