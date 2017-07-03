package io.egen.challenge.service;

import java.util.List;

import io.egen.challenge.entity.User;


public interface UserService {

	public List<User> findAll();

	public User create(User user);

	public User update(String id, User user);

}