package com.bysj.work.babylatter.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bysj.work.babylatter.model.User;
import com.bysj.work.babylatter.model.UserAddress;
import com.bysj.work.babylatter.service.UserService;
import com.bysj.work.babylatter.util.LayuiData;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("list2")
	public String latteruser(){
		
		return "list2";
	}
	@RequestMapping("login")
	public String login(String loginName,String password,HttpSession session){
		
		User user=userService.find(loginName,password);
		int useType=user.getUseType();
		if(user!=null&& useType==0){
			int userId=user.getUserId();
			session.setAttribute("userId", userId);
			User user1=userService.findUserById(userId);
			String userName=user1.getUserName();
			session.setAttribute("userName", userName);
			return "login";
		}
			return "../../index";
	}
	
	@RequestMapping("list1")
	public String list1(){
		
		return "list1";
	}
	@RequestMapping("frontuser")
	public String frontuser(){
		
//		String json_str = json.toString();
//		System.out.println(json_str);
		return "frontuser";
	}
	
	@RequestMapping("frontuserDate")
	@ResponseBody
	public LayuiData<UserAddress> frontuserDate(Integer page,Integer limit,String userName){
		LayuiData<UserAddress> result=new LayuiData<>();
		
		if(userName==null){
		System.out.println("00000000000000"+userName);
		int tpage=(page-1)*limit;
		int count=userService.findAllusertotal();
		List<UserAddress> list=userService.findAlluser(tpage,limit);
		result.setData(list);
		result.setCount(count);
		
		
		}
		else {
			List<UserAddress> list=userService.findByName(userName);
			result.setData(list);
			int count=list.size();
			result.setCount(count);
		}
		return result;
//		String json_str = json.toString();
//		System.out.println(json_str);
		
	}
	
//	@RequestMapping("tableuser")
//	public Map<String, Object> tableuser(){
//		List<UserAddress> list=userService.findAlluser();
//		Map<String,Object> resultMap=new HashMap<String,Object>();
//		resultMap.put("data", list);
//		resultMap.put("code", "1000");
//		resultMap.put("msg", "");
//		resultMap.put("code", "0");
//		resultMap.put("count", String.valueOf(list.size()));
//		return resultMap;
//		
//		
//	}
	
//	删除两个表
	@RequestMapping("deletefUser")
	public String deletefUser(Integer userId){
		
		userService.deletefUser(userId);
//		userService.deletefUserAddress(userId);
		return "forward:/frontuser";
	}
	
	@RequestMapping("enableUser")
	public String enableUser(Integer userId){
		
		userService.enableUser(userId);
//		userService.deletefUserAddress(userId);
		return "forward:/frontuser";
	}
	
	
}
