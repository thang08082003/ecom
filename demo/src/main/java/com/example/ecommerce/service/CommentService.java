package com.example.ecommerce.service;

import com.example.ecommerce.model.Comment;
import com.example.ecommerce.repository.CommentRepository; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }
}
