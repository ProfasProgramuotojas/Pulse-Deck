package com.emcekus.pulsedeck.repository;

import com.emcekus.pulsedeck.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}