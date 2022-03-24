package com.example.demo.Service;


import com.example.demo.model.Comment;
import com.example.demo.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.demo.constants.Constants.DELETE_COMMENT;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepo commentRepo;


    @Override
    public Comment getCommentByPostId(String id) {
        return commentRepo.findByPostId(id);
    }

    @Override
    public Comment addCommentByPostId(Comment comment, String id) {
        return commentRepo.save(comment);
    }

    @Override
    public Comment getCommentByCommentId(String commentId, String postId) {
        return commentRepo.findByPostIdAndCommentId(commentId, postId);
    }

    @Override
    public Comment updateCommentByCommentId(String commentId, String postId,Comment comment) {
        Optional<Comment> commentData=  commentRepo.findById(commentId);
        if (commentData.isPresent()) {
            Comment commentDetails = commentData.get();
            commentDetails.setComment(commentDetails.getComment());
            commentDetails.setCreatedAt(commentDetails.getCreatedAt());
            commentDetails.setCommentedBy(commentDetails.getCommentedBy());
            return  commentDetails;
        }else{
            return null;
        }
    }
    @Override
    public String deleteCommentByCommentId(String commentId, String postId) {
        Comment commentData=commentRepo.deleteAllById(postId,commentId);
        return DELETE_COMMENT;
    }

    @Override
    public Long getCommentsCount(String postId) {
        return null;
    }
}
