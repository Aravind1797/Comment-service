package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.NoArgsConstructor;

import java.util.Date;

@Document(collection="comment_db")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Comment {
    @Id
    private String id;
    private String commentedBy;
    private String comment;
    private Date createdAt;
    private Date updatedAt;


}
