package com.test1.Union.union;

//接口：用于描述工商银行发行的卡片功能，
//在满足银联的基础上，添加自己特有的功能
public interface ICBC extends UnionPay{
	//增加的在线支付功能
	public void payOnline(double number);
}
