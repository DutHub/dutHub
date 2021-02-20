package com.duthub.DutHub.dao.repo;

import com.duthub.DutHub.dao.domain.User;
import com.duthub.DutHub.dao.domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findByUser(User user);
}