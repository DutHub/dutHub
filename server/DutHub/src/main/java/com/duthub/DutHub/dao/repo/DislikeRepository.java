package com.duthub.DutHub.dao.repo;

import com.duthub.DutHub.dao.domain.Dislike;
import com.duthub.DutHub.dao.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DislikeRepository extends JpaRepository<Dislike, Long> {
    List<Dislike> findByUser(User user);
}
