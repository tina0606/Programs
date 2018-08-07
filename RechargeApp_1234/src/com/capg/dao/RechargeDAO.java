package com.capg.dao;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.capg.bean.RechargeDetails;

	public  class RechargeDAO implements IRechargeDAO{
	
	boolean flag=false;
   
    static List<RechargeDetails>list= new ArrayList<RechargeDetails>();
    
	public boolean addRechargeDetails(RechargeDetails recharge)
	{
		flag =list.add(recharge);
	    return flag;
	}

	public RechargeDetails displayRechargeDetails(long transactionId)
	{
		Iterator<RechargeDetails> it=list.iterator();
		while(it.hasNext())
		{
			RechargeDetails r;
			r=it.next();
			if(r.getTransactionId()==transactionId)
			{
			return r;
			}
		}
			return null;
	}
	public boolean updateRechargeDetails(RechargeDetails newR)
	{
		Iterator<RechargeDetails> it=list.iterator();
		while(it.hasNext())
		{
			RechargeDetails r;
			r=it.next();
			if(r.getTransactionId()==newR.getTransactionId())
			{
				r.setDthOperator(newR.getDthOperator());	
				r.setConsumerNo(newR.getConsumerNo());
				r.setRechargePlan(newR.getRechargePlan());
				r.setAmount(newR.getAmount());
			
				if(r.getDthOperator()==newR.getDthOperator()&& r.getConsumerNo()==newR.getConsumerNo() && r.getRechargePlan()==newR.getRechargePlan() && r.getAmount()==newR.getAmount() )
					return flag=true;
			
			}
		}
		return flag;
	}

	@Override
	public boolean removeRechargeDetails(long transactionId)
	{
		Iterator<RechargeDetails> it=list.iterator();
		while(it.hasNext())
		{
			RechargeDetails r;
			r=it.next();
			if(r.getTransactionId()==transactionId)
			{
			return list.remove(r);
			}
		}
			return false;
	}
	
	public List<RechargeDetails> displayAllRechargeDetails()
	{
		
	return list;
		}
	}
