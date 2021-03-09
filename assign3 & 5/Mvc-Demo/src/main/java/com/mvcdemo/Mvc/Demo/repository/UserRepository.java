package com.mvcdemo.Mvc.Demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mvcdemo.Mvc.Demo.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	public List<User> findAll();

	public User findOneById(Integer id);
}
