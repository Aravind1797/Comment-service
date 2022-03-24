
package com.example.demo.repo;

import com.example.demo.model.Comment;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends MongoRepository<Comment, String> {
    Comment findByPostId(String postId);
    Comment findByPostIdAndCommentId(String postId,String commentId);

    Comment deleteAllById(String postId, String commentId);
}
