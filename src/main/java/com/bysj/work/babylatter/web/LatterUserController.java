package com.bysj.work.babylatter.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bysj.work.babylatter.model.User;
import com.bysj.work.babylatter.model.UserAddress;
import com.bysj.work.babylatter.service.UserService;
import com.bysj.work.babylatter.util.LayuiData;

@Controller
public class LatterUserController {
	@Autowired
	private UserService userService;

	@RequestMapping("latteruser")
	public String latteruser(){
		
		return "latteruser";
	}
	
	@RequestMapping("latteruserDate")
	@ResponseBody
	public LayuiData<UserAddress> latteruserDate(Integer page,Integer limit,String userName){
		LayuiData<UserAddress> result=new LayuiData<>();
		if(userName==null){
			
			int tpage=(page-1)*limit;
			List<UserAddress> listtotal=userService.Lattertotal();
			List<UserAddress> list=userService.LatterAlluser(tpage,limit);
			result.setData(list);
			int count =listtotal.size();
			result.setCount(count);
			
			
			}
			else {
				List<UserAddress> list=userService.LatterfindByName(userName);
				result.setData(list);
				int count=list.size();
				result.setCount(count);
			}
			return result;
	}
	
	@RequestMapping("deletelUser")
	public String deletelUser(Integer userId){
		
		userService.deletelUser(userId);
		
		return "forward:/latteruser";
	}
	@RequestMapping("enablelUser")
	public String enableIUser(Integer userId){
		userService.enableIUser(userId);
		
		return "forward:/latteruser";
	}
	
	
	//更改界面
	@RequestMapping("changepassword")
	public String changepassword(){
		
		return "changepassword";
	}
	//更改密码表单验证
	@RequestMapping("editpassword")
	public String editpassword(String password,String newpassword,HttpSession session){
		int userId=(int) session.getAttribute("userId");
		User user=userService.findUserById(userId);
		String Psw =user.getPassword();
		if(Psw.equals(password)){
			userService.updateMM(userId,newpassword);
			return "pswsuccess";
		}else{
			return "pswfailed";
		}
		
		
	}
	@RequestMapping("exit")
	public String exit(){
		return "../../index";
	}
	
	
}
