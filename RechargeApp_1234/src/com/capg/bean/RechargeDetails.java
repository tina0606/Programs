package com.capg.bean;

public class RechargeDetails {

private	String dthOperator;
private int ConsumerNo;
private String rechargePlan;
private int amount;
private long transactionId;
public String getDthOperator() {
	return dthOperator;
}
public void setDthOperator(String dthOperator) {
	this.dthOperator = dthOperator;
}
public int getConsumerNo() {
	return ConsumerNo;
}
public void setConsumerNo(int consumerNo) {
	ConsumerNo = consumerNo;
}
public String getRechargePlan() {
	return rechargePlan;
}
public void setRechargePlan(String rechargePlan) {
	this.rechargePlan = rechargePlan;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public long getTransactionId() {
	return transactionId;
}
public void setTransactionId(long transactionId) {
	this.transactionId = transactionId;
}
@Override
public String toString() {
	return "RechargeDetails [dthOperator=" + dthOperator + ", ConsumerNo=" + ConsumerNo + ", rechargePlan="
			+ rechargePlan + ", amt=" + amount + ", transactionId=" + transactionId + "]";
}	
}
