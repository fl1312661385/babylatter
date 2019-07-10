package com.bysj.work.babylatter.service;

import java.util.List;

import com.bysj.work.babylatter.model.Order;

public interface OrderService {

	List<Order> findAllorder(int tpage, Integer limit);

	int total();

	List<Order> findByName(int tpage, Integer limit, String userName);

	int Onetotal(String userName);

	void sendgoods(Integer orderId);

	Order getOneorder(Integer orderId);

	void updateorder(Integer orderId, Order order);

	void delorder(Integer orderId);


}
