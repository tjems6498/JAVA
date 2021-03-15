package com.example.demo.shop.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.shop.model.Category;
import com.example.demo.shop.model.Product;
import com.example.demo.shop.model.ShopMember;
import com.example.demo.shop.service.ProductService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/products") // 이 컨트롤러의 기본 uri
public class ProductController {
	private String basePath = "C:\\shop_img\\";
	@Autowired
	private ProductService service;

	// 상품카테고리로 검색, 상품판매자로 검색, 상품전체목록
	
	// 상품추가
	@PostMapping("")
	public Map addProduct(Product p) {
		boolean flag = false;
		try {
			Product p2 = service.addProduct(p);
			int num = p2.getNum();
			String fpath = basePath + num + "\\";
			File dir = new File(fpath);
			dir.mkdir();//이미지 저장할 폴더 생성: C:\\shop_img\\33
			
			MultipartFile[] files = { p.getFile1(), p.getFile2(), p.getFile3(), p.getFile4() };
			int cnt = 1;
			
			String end = "";
			for (MultipartFile f : files) {			
				if (f != null) {
					int idx = f.getOriginalFilename().lastIndexOf(".");
					end = f.getOriginalFilename().substring(idx);//.확장자 추출
					File ff = new File(fpath + cnt + end);
					cnt++;
					f.transferTo(ff);
				}
			}
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		Map map = new HashMap();
		map.put("result", flag);
		return map;
	}
	
	//물품번호로 검색
	@GetMapping("/{num}")
	public Map getProduct(@PathVariable("num") int num) {
		Map model = new HashMap();
		boolean result = false;
		try {
			Product p = service.getProduct(num);
			// 파일이 null로 보임
			model.put("data", p);
			result = true;
		}catch(Exception e){
			result = false;
		}
		model.put("result", result);
		return model;
		}
	
	// 판매자로 검색
	@GetMapping("/seller/{seller}")
	public Map getBySeller(@PathVariable("seller") String id) {
		Map model = new HashMap();
		boolean result = false;
		try {
			ArrayList<Product> list = service.getBySeller(id);
			model.put("data", list);
			
			result = true;
		}catch(Exception e){
			result = false;
		}
		model.put("result", result);
		return model;
		}
	
	// 카테고리로 검색
	@GetMapping("/cate/{num}")
	public Map getByCate(@PathVariable("num") int num) {
		Map model = new HashMap();
		boolean result = false;
		try {
			ArrayList<Product> list = service.getByCate(num);
			model.put("data", list);
			result = true;
		}catch(Exception e) {
			result = false;
		}
		model.put("result", result);
		return model;
	}
	
	// 전체 검색
	@GetMapping("")
	public Map getAllProduct() {
		Map model = new HashMap();
		boolean result = false;
		try {
			ArrayList<Product> list = service.getAll();
			model.put("data", list);
			result = true;
		}catch(Exception e){
			result = false;
		}
		model.put("result", result);
		return model;
		}
	

	// 물품수정
	@PutMapping("")
	public Map editProduct(Product p) {
		boolean flag = false;
		Product x = null;
		Map map = new HashMap();
		try {
			// 왜 수정인데 product가 복사가 되지?
			service.editProduct(p);
			x = service.getProduct(p.getNum());
			map.put("edit_p", x);
			flag = true;
		}catch(Exception e) {
			flag = false;
		}
		map.put("result", flag);
		return map;
		
	}
	
	// 물품 삭제
	@DeleteMapping("/{num}")
	public Map delProduct(@PathVariable("num") int num) {
		boolean flag = false;
		try {
			service.delProduct(num);
			flag = true;
		}catch(Exception e) {
			flag = false;
		}
		Map map = new HashMap();
		map.put("result", flag);
		return map;
	}
	
	

	
	
}
