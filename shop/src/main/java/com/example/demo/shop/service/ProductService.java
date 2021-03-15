package com.example.demo.shop.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.shop.model.Product;
import com.example.demo.shop.model.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repos;
	
	//상품등록, 상품번호로검색, 상품수정, 상품삭제, 상품카테고리로 검색, 상품판매자로 검색, 상품전체목록
	public Product addProduct(Product p) {
		return repos.save(p);
	}
	
	public void editProduct(Product p) {
		repos.save(p);
	}
	
	public void delProduct(int num) {
		repos.deleteById(num);
	}
	
	public ArrayList<Product> getAll(){
		return (ArrayList<Product>) repos.findAll();
	}
	
	public Product getProduct(int num) {
		return repos.getOne(num);
	}
	
	public ArrayList<Product> getByCate(int num){
		return repos.findByCate(num);
	}
	
	public ArrayList<Product> getBySeller(String seller){
		return repos.findBySeller(seller);
	}
	
}
