package com.capg.service;

public class RechargeDataValidate {

	
	
	public boolean validatedthOperator(String dthOperator)
	{  if(dthOperator.equalsIgnoreCase("Airtel")||dthOperator.equalsIgnoreCase("DishTv")||dthOperator.equalsIgnoreCase("Reliance")||dthOperator.equalsIgnoreCase("TataSky"))
		return true;
	else
		return false;
		
	}

     public boolean validateConsumerNo(String ConsumerNo)
     { if(ConsumerNo.length()==10)
    	 
    	 return true;
	else
		return false;
    	
     }
     
     public boolean validatePlan(String rechargePlan)
     {
    	
		if(rechargePlan.equalsIgnoreCase("Monthly")||rechargePlan.equalsIgnoreCase("Quarterly") ||rechargePlan.equalsIgnoreCase("Half Yearly") ||rechargePlan.equalsIgnoreCase("Annual"))
    	 
    	 return true;
	else
		return false;
    	
    	 
    	 
     }

     public boolean validateAmount(String amount)

     {
    	 return true;
     }
}
