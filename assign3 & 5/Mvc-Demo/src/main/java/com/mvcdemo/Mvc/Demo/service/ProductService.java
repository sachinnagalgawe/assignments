package com.mvcdemo.Mvc.Demo.service;

import java.util.List;

import com.mvcdemo.Mvc.Demo.entity.Product;

public interface ProductService {

	public Product create(Product product);

	public List<Product> findAll();

	public Product findById(int productId);

	public Product updateById(int productId, Product product);
	
	public void deleteById(int productId);

}
