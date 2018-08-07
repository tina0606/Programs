package com.capg.dao;

import java.util.List;

import com.capg.bean.RechargeDetails;

public interface IRechargeDAO 
{

	public boolean addRechargeDetails(RechargeDetails recharge);
	public RechargeDetails displayRechargeDetails(long transactionId);
	public boolean updateRechargeDetails(RechargeDetails newR);
	public boolean removeRechargeDetails(long transactionId);
	public List<RechargeDetails> displayAllRechargeDetails();

}
