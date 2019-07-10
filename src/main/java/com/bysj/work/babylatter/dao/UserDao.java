package com.bysj.work.babylatter.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bysj.work.babylatter.model.User;
import com.bysj.work.babylatter.model.UserAddress;

public interface UserDao {




	User find(@Param("loginName")String loginName, @Param("password")String password);


	List<UserAddress> findAlluser(@Param("page")Integer page, @Param("limit")Integer limit);



	int findAllusertotal();


	void deletefUser(Integer userId);


	void deletefUserAddress(Integer userId);


	List<UserAddress> findByName(@Param("userName")String userName);


	List<UserAddress> Lattertotal();


	List<UserAddress> LatterAlluser(@Param("page")int tpage, @Param("limit")Integer limit);


	List<UserAddress> LatterfindByName(@Param("userName")String userName);


	void deletelUser(Integer userId);


	User findUserById(int userId);


	void updateMM(@Param("userId")int userId,@Param("password") String newpassword);


	void enableUser(Integer userId);


	void enableIUser(Integer userId);

	

}
