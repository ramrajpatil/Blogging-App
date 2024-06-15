package com.app.service;

import com.app.pojos.User;

public interface UserService {
	User addUser(User user);

	User getUser(String email, String password);

	User getUserById(Long id);
}
