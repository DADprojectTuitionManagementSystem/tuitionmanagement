package com.tuition.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tuition.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);

	User findByUsername(String username);
	
	List<User> findByRole(String role);
}
