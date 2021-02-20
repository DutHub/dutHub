package com.duthub.DutHub.dao.repo;

import com.duthub.DutHub.dao.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}