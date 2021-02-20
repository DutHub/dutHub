package com.duthub.DutHub.dao.repo;

import com.duthub.DutHub.dao.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
