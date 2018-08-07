package com.capg.service;

import java.util.List;

import com.capg.bean.RechargeDetails;
import com.capg.dao.RechargeDAO;

public class RechargeService implements IRechargeService {

	RechargeDAO dao= new RechargeDAO();
	int n=0;
	
	public boolean addRechargeDetails(RechargeDetails recharge)
	{
		return dao.addRechargeDetails(recharge);
	}

	public RechargeDetails displayRechargeDetails(long transactionId)
	{
		return dao.displayRechargeDetails(transactionId);
	}

	@Override
	public boolean updateRechargeDetails(RechargeDetails newR) {
		// TODO Auto-generated method stub
		return dao.updateRechargeDetails(newR);
	}

	@Override
	public boolean removeRechargeDetails(long transactionId) {
		// TODO Auto-generated method stub
		return dao.removeRechargeDetails(transactionId);
	}

	public Object displayAllRechargeDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	 
}







