package com.bysj.work.babylatter.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bysj.work.babylatter.model.Bill;
import com.bysj.work.babylatter.model.Comment;
import com.bysj.work.babylatter.service.BillService;
import com.bysj.work.babylatter.util.LayuiData;

@Controller
public class BillController {
	/**
	*@author fengliang
	*2019年4月10日
	*com.bysj.work.babylatter.web
	*/
	@Autowired
	private BillService billService;
	
	@RequestMapping("bill")
	public String bill(){
		return "bill";
	}
	@ResponseBody
	@RequestMapping("billData")
	public LayuiData<Bill> billData(Integer page,Integer limit,String replyName){
		LayuiData<Bill> result=new LayuiData<>();
		if(replyName==null){
			int tpage=(page-1)*limit;
			int count=billService.findAllBill();
			List<Bill> listpage=billService.getAllBill(tpage,limit);
			result.setData(listpage);
			result.setCount(count);
		}else{
			int tpage=(page-1)*limit;
			List<Bill> list=billService.findByName(tpage,limit,replyName);
			result.setData(list);
			int count=billService.Onetotal(replyName);
			result.setCount(count);
			}
		
		return result;
	}
	@ResponseBody
	@RequestMapping("delbill")
	public int  delbill(int billId){
		
		return billService.delbill(billId);
		
	}
	
	
	
}
