package com.bysj.work.babylatter.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bysj.work.babylatter.model.Bill;

public interface BillDao {

	int findAllbill();

	List<Bill> getAllbill(@Param("page")int tpage,@Param("limit")Integer limit);

	List<Bill> findByName(@Param("page")int tpage, @Param("limit")Integer limit, @Param("replyName")String replyName);

	int Onetotal(@Param("replyName")String replyName);

	int delbill(int billId);

}
