package io.egen.challenge.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.challenge.entity.User;
import io.egen.challenge.exception.UserAlreadyExistsException;
import io.egen.challenge.exception.UserNotFoundException;
import io.egen.challenge.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	@Override
	@Transactional
	public User create(User user) {
		User existing = userRepository.findOne(user.getId());
		if (existing != null) {
			throw new UserAlreadyExistsException("User is already present: " + user.getId());
		}
		return userRepository.create(user);
	}

	
	@Override
	@Transactional
	public User update(String id, User user) {
		User existing = userRepository.findOne(id);
		if (existing == null) {
			throw new UserNotFoundException("User with id:" + id + " not found");
		}
		user.setId(id);
		
		return userRepository.update(user);
	}

}
