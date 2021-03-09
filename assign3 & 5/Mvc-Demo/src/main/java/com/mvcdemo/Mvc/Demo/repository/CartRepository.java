package com.mvcdemo.Mvc.Demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mvcdemo.Mvc.Demo.entity.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {

	public Cart findOneById(Integer cartId);

	public Cart findOneByUserId(Integer userId);

}
