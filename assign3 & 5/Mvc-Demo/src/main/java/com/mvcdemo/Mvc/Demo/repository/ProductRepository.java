package com.mvcdemo.Mvc.Demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mvcdemo.Mvc.Demo.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	public Product findOneById(Integer productId);
}
