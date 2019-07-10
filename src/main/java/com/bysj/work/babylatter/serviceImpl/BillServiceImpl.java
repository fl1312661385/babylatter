package com.bysj.work.babylatter.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bysj.work.babylatter.dao.BillDao;
import com.bysj.work.babylatter.model.Bill;
import com.bysj.work.babylatter.service.BillService;
@Service
public class BillServiceImpl implements BillService {
	/**
	*@author fengliang
	*2019年4月10日
	*com.bysj.work.babylatter.serviceImpl
	*/
	@Autowired 
	private BillDao billDao;

	@Override
	public int findAllBill() {
		// TODO Auto-generated method stub
		return billDao.findAllbill();
	}

	@Override
	public List<Bill> getAllBill(int tpage, Integer limit) {
		// TODO Auto-generated method stub
		return billDao.getAllbill(tpage,limit);
	}

	@Override
	public List<Bill> findByName(int tpage, Integer limit, String replyName) {
		// TODO Auto-generated method stub
		return billDao.findByName(tpage,limit,replyName);
	}

	@Override
	public int Onetotal(String replyName) {
		// TODO Auto-generated method stub
		return billDao.Onetotal(replyName);
	}

	@Override
	public int delbill(int billId) {
		// TODO Auto-generated method stub
		return billDao.delbill(billId);
	}
}
