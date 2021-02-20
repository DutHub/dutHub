package com.duthub.DutHub.dao.repo;

import com.duthub.DutHub.dao.domain.Comment;
import com.duthub.DutHub.dao.domain.User;
import com.duthub.DutHub.dao.domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByVideo(Video video);
    List<Comment> findByUser(User user);
}