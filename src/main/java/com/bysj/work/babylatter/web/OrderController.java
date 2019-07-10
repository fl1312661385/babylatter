package com.bysj.work.babylatter.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bysj.work.babylatter.model.Order;
import com.bysj.work.babylatter.model.Product;
import com.bysj.work.babylatter.model.UserAddress;
import com.bysj.work.babylatter.service.OrderService;
import com.bysj.work.babylatter.util.LayuiData;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	@RequestMapping("order")
	public String order(){
		
		return "order";
	}
	
	
	@RequestMapping("orderData")
	@ResponseBody
	public LayuiData<Order> orderData(Integer page,Integer limit,String userName){
		LayuiData<Order> result=new LayuiData<>();
		if(userName==null){
			int tpage=(page-1)*limit;
			List<Order> list=orderService.findAllorder(tpage,limit);
			int count=orderService.total();
			result.setData(list);
			result.setCount(count);
		}else{
			int tpage=(page-1)*limit;
			List<Order> list=orderService.findByName(tpage,limit,userName);
			result.setData(list);
			//一个商品总数
			int count=orderService.Onetotal(userName);
			result.setCount(count);
			}
		return result;
	}
	
	@RequestMapping("sendgoods")
	public String sendgoods(Integer orderId){
		orderService.sendgoods(orderId);
		return "forward:/order";
	}
	
	
	@RequestMapping("editorder")
	public String editorder(Integer orderId,HttpServletRequest request,HttpSession session){
		Order order=orderService.getOneorder(orderId);
		request.setAttribute("order", order);
		session.setAttribute("orderId", orderId);
		return "editorder";
	}
	
	@RequestMapping("updateorder")
	@ResponseBody
	public void updateorder(Order order,HttpSession session){
		int orderId= (int) session.getAttribute("orderId");
		System.out.println("99999999999999999999"+orderId);
		orderService.updateorder(orderId,order);
		
	}
	@ResponseBody
	@RequestMapping("delorder")
	public int delorder(Integer orderId){
		orderService.delorder(orderId);
		return 1;
	}
	
}
