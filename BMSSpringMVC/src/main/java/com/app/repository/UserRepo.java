package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	// Method to persist User
	User save(User user);

	// Method to authenticate the user
	Optional<User> findByEmailAndPassword(String email, String password);

	Optional<User> findById(Long id);
}
