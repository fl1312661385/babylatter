package com.bysj.work.babylatter.service;

import java.util.List;

import com.bysj.work.babylatter.model.User;
import com.bysj.work.babylatter.model.UserAddress;

public interface UserService {


	User find(String loginName, String password);

	List<UserAddress> findAlluser(Integer page, Integer limit);


	int findAllusertotal();

	void deletefUser(Integer userId);

	void deletefUserAddress(Integer userId);

	List<UserAddress> findByName(String userName);

	List<UserAddress> Lattertotal();

	List<UserAddress> LatterAlluser(int tpage, Integer limit);

	List<UserAddress> LatterfindByName(String userName);

	void deletelUser(Integer userId);

	User findUserById(int userId);

	void updateMM(int userId, String newpassword);

	void enableUser(Integer userId);

	void enableIUser(Integer userId);

	

}
