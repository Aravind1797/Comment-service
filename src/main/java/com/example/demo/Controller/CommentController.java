package com.example.demo.Controller;


import com.example.demo.Service.CommentService;
import com.example.demo.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value ="Post/{post id}")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @PostMapping("/{postId}/comments")
    public ResponseEntity<Comment> addComment( @RequestBody Comment comment,@PathVariable("postId") String postId) {
        Comment commentData = commentService.addCommentByPostId(comment,postId);
        return new ResponseEntity<>(commentData, HttpStatus.CREATED);
    }

    @GetMapping("/{postId}/comments")
    public ResponseEntity<Optional<Comment>> getCommentsByPostId(@PathVariable("postId") String postId) {
        Optional<Comment> commentData = Optional.ofNullable(commentService.getCommentByPostId(postId));
        return new ResponseEntity<>(commentData, HttpStatus.OK);
    }

    @GetMapping("/{postId}/comments/{commentId}")
    public ResponseEntity<Comment> getCommentsByPostIdAndCommentId(@PathVariable("postId") String postId, @PathVariable("commentId") String commentId) {
        Comment commentData = commentService.getCommentByCommentId(postId, commentId);
        return new ResponseEntity<>(commentData, HttpStatus.OK);
    }


    @PutMapping("/{postId}/comments/{commentId}")
    public ResponseEntity<Comment> updateCommentByPostIdAndCommentId(@PathVariable("postId") String postId, @PathVariable("commentId") String commentId, @RequestBody Comment comment) {
        Comment commentData = commentService.updateCommentByCommentId(postId, commentId, comment);
        return new ResponseEntity<>(commentData, HttpStatus.OK);
    }

    @DeleteMapping("/{postId}/comments/{commentId}")
    public ResponseEntity<String> deleteCommentByPostId(@PathVariable("postId") String postId, @PathVariable("commentId") String commentId) {
        String commentData = commentService.deleteCommentByCommentId(postId, commentId);
        return new ResponseEntity<>(commentData, HttpStatus.OK);
    }

    @GetMapping("/{postId}/comments/count")
    public ResponseEntity<Long> getCommentsCount(String postId) {
        Long commentCount = commentService.getCommentsCount(postId);
        return new ResponseEntity<>(commentCount, HttpStatus.OK);
    }
