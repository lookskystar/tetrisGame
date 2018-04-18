package com.test1.Union.unionImpl;

import com.test1.Union.union.ABC;

//类：用于描述工商银行实际发行的卡片
//该卡片具有的功能实现ICBC的接口
public class ABCImpl implements ABC {
	private double money;
	private String pwd;
	//卡内余额，允许最多透支2000
	private double balance;
	
	public ABCImpl(double money, String pwd) {
		super();
		this.money = money;
		this.pwd = pwd;
	}
	
	
	//检查密码
	@Override
	public boolean checkPwd(String input) {
		if(pwd.equals(input)){
			return true;
		}
		return false;
	}

	//取钱
	@Override
	public boolean drawMoney(double number) {
		//判断取钱的金额是否比余额要小
		if(number<=money){
			money-=number; //余额-你要取的金额
			return true;
		}
		return false;
	}

	//查询余额
	@Override
	public double getBalance() {
		return money;
	}

	//支付电话费
	@Override
	public boolean payTelBill(String phoneNum, double sum) {
		if(phoneNum.length()==11&&(balance-sum)>=-2000){
			balance-=sum;
			return true;
		}
		return false;
	}
	
}
