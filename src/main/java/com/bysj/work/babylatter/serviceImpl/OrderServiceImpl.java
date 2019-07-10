package com.bysj.work.babylatter.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bysj.work.babylatter.dao.OrderDao;
import com.bysj.work.babylatter.model.Order;
import com.bysj.work.babylatter.service.OrderService;
@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;

	@Override
	public List<Order> findAllorder(int tpage, Integer limit) {
		// TODO Auto-generated method stub
		return orderDao.findAllorder(tpage,limit);
	}

	@Override
	public int total() {
		// TODO Auto-generated method stub
		return orderDao.total();
	}

	@Override
	public List<Order> findByName(int tpage, Integer limit, String userName) {
		// TODO Auto-generated method stub
		return orderDao.findByName(tpage,limit,userName);
	}

	@Override
	public int Onetotal(String userName) {
		// TODO Auto-generated method stub
		return orderDao.Onetotal(userName);
	}

	@Override
	public void sendgoods(Integer orderId) {
		// TODO Auto-generated method stub
		orderDao.sendgoods(orderId);
	}

	@Override
	public Order getOneorder(Integer orderId) {
		// TODO Auto-generated method stub
		return orderDao.getOneorder(orderId);
	}

	@Override
	public void updateorder(Integer orderId, Order order) {
		// TODO Auto-generated method stub
		orderDao.updateorder(orderId,order);
	}

	@Override
	public void delorder(Integer orderId) {
		// TODO Auto-generated method stub
		orderDao.delorder(orderId);
	}

	
}
