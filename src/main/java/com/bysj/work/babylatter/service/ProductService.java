package com.bysj.work.babylatter.service;

import java.util.List;

import com.bysj.work.babylatter.model.Product;

public interface ProductService {

	List<Product> findAllproduct(int tpage, Integer limit);

	int total();

	List<Product> findByproductName(int tpage, Integer limit, String productName);

	int Onetotal(String productName);

	void productshow(Integer productId);

	Product getOneproduct(Integer productId);

	void updateProduct(Integer productId, Product product);

	List<Product> findAllunderproduct(int tpage, Integer limit);

	int undertotal();

	void productshowup(Integer productId);

	void insertProduct(Product product);

	void delproduct(Integer productId);

}
