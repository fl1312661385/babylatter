package com.bysj.work.babylatter.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bysj.work.babylatter.model.Product;

public interface ProductDao {



	int total();

	List<Product> findAllproduct(@Param("page")int tpage,@Param("limit") Integer limit);


	List<Product> findByproductName(@Param("page")int tpage, @Param("limit")Integer limit, @Param("productName")String productName);

	int Onetotal(@Param("productName")String productName);

	void productshow(Integer productId);

	Product getOneproduct(Integer productId);

	void updateProduct(@Param("productId")Integer productId,@Param("product") Product product);

	List<Product> findAllunderproduct(@Param("page")int tpage, @Param("limit")Integer limit);

	int undertotal();

	void productshowup(Integer productId);

	void insertProduct(Product product);

	void delproduct(Integer productId);

}
