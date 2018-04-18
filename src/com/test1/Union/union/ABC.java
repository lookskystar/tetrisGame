package com.test1.Union.union;

//接口：用于描述农业银行发行的卡片功能，
//在满足银联的基础上，添加自己特有的功能
public interface ABC extends UnionPay{
	//增加支付电话费的功能
	public boolean payTelBill(String phoneNum,double sum);
}
