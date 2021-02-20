package com.duthub.DutHub.dao.repo;


import com.duthub.DutHub.dao.domain.Like;
import com.duthub.DutHub.dao.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByUser(User user);
}
