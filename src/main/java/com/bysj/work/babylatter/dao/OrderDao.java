package com.bysj.work.babylatter.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bysj.work.babylatter.model.Order;

public interface OrderDao {

	List<Order> findAllorder(@Param("page")int tpage, @Param("limit")Integer limit);

	int total();

	List<Order> findByName(@Param("page")int tpage,@Param("limit") Integer limit, @Param("userName")String userName);

	int Onetotal(@Param("userName")String userName);

	void sendgoods(Integer orderId);

	Order getOneorder(Integer orderId);

	void updateorder(@Param("orderId")Integer orderId, @Param("order")Order order);

	void delorder(Integer orderId);

}
