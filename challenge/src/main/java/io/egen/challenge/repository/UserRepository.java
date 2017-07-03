package io.egen.challenge.repository;
import java.util.List;

import io.egen.challenge.entity.User;


public interface UserRepository {

	public List<User> findAll();
	
	public User findOne(String id);
	public User create(User user);

	public User update(User user);
}
