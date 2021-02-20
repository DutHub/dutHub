package com.duthub.DutHub.dao.repo;

import com.duthub.DutHub.dao.domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {

}