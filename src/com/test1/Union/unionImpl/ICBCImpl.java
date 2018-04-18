package com.test1.Union.unionImpl;

import com.test1.Union.union.ICBC;

//类：用于描述工商银行实际发行的卡片
//该卡片具有的功能实现ICBC的接口
public class ICBCImpl implements ICBC {
	private double money;
	private String pwd;
	
	public ICBCImpl(double money, String pwd) {
		super();
		this.money = money;
		this.pwd = pwd;
	}
	
	//在线支付
	@Override
	public void payOnline(double number) {
		if(number<money){
			money-=number;
		}
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
	
}
