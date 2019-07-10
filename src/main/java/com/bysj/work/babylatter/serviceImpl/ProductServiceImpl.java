package com.bysj.work.babylatter.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bysj.work.babylatter.dao.ProductDao;
import com.bysj.work.babylatter.model.Product;
import com.bysj.work.babylatter.service.ProductService;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;


	@Override
	public int total() {
		// TODO Auto-generated method stub
		return productDao.total();
	}

	@Override
	public List<Product> findAllproduct(int tpage, Integer limit) {
		// TODO Auto-generated method stub
		return productDao.findAllproduct(tpage,limit);
	}


	@Override
	public List<Product> findByproductName(int tpage, Integer limit, String productName) {
		// TODO Auto-generated method stub
		return productDao.findByproductName(tpage,limit,productName);
	}

	@Override
	public int Onetotal(String productName) {
		// TODO Auto-generated method stub
		return productDao.Onetotal(productName);
	}

	@Override
	public void productshow(Integer productId) {
		// TODO Auto-generated method stub
		productDao.productshow(productId);
	}

	@Override
	public Product getOneproduct(Integer productId) {
		// TODO Auto-generated method stub
		return productDao.getOneproduct(productId);
	}

	@Override
	public void updateProduct(Integer productId, Product product) {
		// TODO Auto-generated method stub
		productDao.updateProduct(productId,product);
	}

	@Override
	public List<Product> findAllunderproduct(int tpage, Integer limit) {
		// TODO Auto-generated method stub
		return productDao.findAllunderproduct(tpage,limit);
	}

	@Override
	public int undertotal() {
		// TODO Auto-generated method stub
		return productDao.undertotal();
	}

	@Override
	public void productshowup(Integer productId) {
		// TODO Auto-generated method stub
		productDao.productshowup(productId);
	}

	@Override
	public void insertProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.insertProduct(product);
	}

	@Override
	public void delproduct(Integer productId) {
		// TODO Auto-generated method stub
		productDao.delproduct(productId);
	}
}
