package com.mvcdemo.Mvc.Demo.service;

import java.util.List;

import com.mvcdemo.Mvc.Demo.entity.Cart;

public interface CartService {

	public Cart getCartForTheUser(Integer userId);

	public List<Cart> getAllCarts();

	public Cart create(Cart cart);

	public Cart updateById(Integer cartId, Cart cart);

	public void deleteById(Integer cartId);

}
