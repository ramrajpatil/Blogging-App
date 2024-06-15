package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exception.CustomNoResultException;
import com.app.pojos.User;
import com.app.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepo userRepo;

	@Override
	public User addUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User getUser(String email, String password) {
		User user = userRepo.findByEmailAndPassword(email, password)
				.orElseThrow(() -> new CustomNoResultException("Wrong Credentials, try again!!!"));
		return user;
	}

	@Override
	public User getUserById(Long id) {
		return userRepo.findById(id).orElseThrow(() -> new CustomNoResultException("No such user with given ID"));
	}

}
