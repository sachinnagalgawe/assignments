package com.mvcdemo.Mvc.Demo.service;

import java.util.List;

import com.mvcdemo.Mvc.Demo.entity.User;

public interface UserService {

	public User create(User user);

	public List<User> findAll();

	public User findById(Integer id);

	public User updateById(Integer id, User user);

	public void deleteById(Integer id);
}
