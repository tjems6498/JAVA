package com.example.demo.shop.model;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	ArrayList<Product> findBySeller(String seller);
	ArrayList<Product> findByCate(int cate);
}
