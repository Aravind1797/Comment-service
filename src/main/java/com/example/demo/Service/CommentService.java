package com.example.demo.services;


import com.example.demo.model.Comment;

import java.util.Optional;

public interface CommentService {

    Comment getCommentByPostId(String id);
    Comment addCommentByPostId(Comment comment, String id);
    Comment getCommentByCommentId(String commentId,String postId);
    Comment updateCommentByCommentId(String commentId,String postId,Comment comment);
    String deleteCommentByCommentId(String commentId,String postId);


    Long getCommentsCount(String postId);
}
