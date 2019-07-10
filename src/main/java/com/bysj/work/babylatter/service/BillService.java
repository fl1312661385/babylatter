package com.bysj.work.babylatter.service;

import java.util.List;

import com.bysj.work.babylatter.model.Bill;

public interface BillService {

	int findAllBill();

	List<Bill> getAllBill(int tpage, Integer limit);

	List<Bill> findByName(int tpage, Integer limit, String replyName);

	int Onetotal(String replyName);

	int delbill(int billId);

}
