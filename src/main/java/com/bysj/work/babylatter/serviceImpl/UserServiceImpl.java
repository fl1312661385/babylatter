package com.bysj.work.babylatter.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bysj.work.babylatter.dao.UserDao;
import com.bysj.work.babylatter.model.User;
import com.bysj.work.babylatter.model.UserAddress;
import com.bysj.work.babylatter.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	
	@Override
	public User find(String loginName, String password) {
		// TODO Auto-generated method stub
		System.out.println("000000000000000000000"+loginName+password);
		return userDao.find(loginName,password);
	}



	@Override
	public List<UserAddress> findAlluser(Integer page, Integer limit) {
		// TODO Auto-generated method stub
		return userDao.findAlluser(page,limit);
	}



	@Override
	public int findAllusertotal() {
		// TODO Auto-generated method stub
		return userDao.findAllusertotal();
	}



	@Override
	public void deletefUser(Integer userId) {
		// TODO Auto-generated method stub
		userDao.deletefUser(userId);
	
	}



	@Override
	public void deletefUserAddress(Integer userId) {
		// TODO Auto-generated method stub
		userDao.deletefUserAddress(userId);
	}



	@Override
	public List<UserAddress> findByName(String userName) {
		// TODO Auto-generated method stub
		return userDao.findByName(userName);
	}



	@Override
	public List<UserAddress> Lattertotal() {
		// TODO Auto-generated method stub
		return userDao.Lattertotal();
	}



	@Override
	public List<UserAddress> LatterAlluser(int tpage, Integer limit) {
		// TODO Auto-generated method stub
		return userDao.LatterAlluser(tpage,limit);
	}



	@Override
	public List<UserAddress> LatterfindByName(String userName) {
		// TODO Auto-generated method stub
		return userDao.LatterfindByName(userName);
	}



	@Override
	public void deletelUser(Integer userId) {
		// TODO Auto-generated method stub
		userDao.deletelUser(userId);
	}



	@Override
	public User findUserById(int userId) {
		// TODO Auto-generated method stub
		return userDao.findUserById(userId);
	}



	@Override
	public void updateMM(int userId, String newpassword) {
		// TODO Auto-generated method stub
		userDao.updateMM(userId,newpassword);
	}



	@Override
	public void enableUser(Integer userId) {
		// TODO Auto-generated method stub
		userDao.enableUser(userId);
	}



	@Override
	public void enableIUser(Integer userId) {
		// TODO Auto-generated method stub
		userDao.enableIUser(userId);
	}

	
}
