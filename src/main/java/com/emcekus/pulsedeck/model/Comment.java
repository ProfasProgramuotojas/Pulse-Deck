package com.emcekus.pulsedeck.model;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private String product;

    private String comment;

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public Long getCommentId() {
        return commentId;
    }

    public String getProduct() {
        return product;
    }

    public String getComment() {
        return comment;
    }
}