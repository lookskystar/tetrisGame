package com.test1.Union.union;
//接口，用于描述银联同意制定的规则
public interface UnionPay {
	//接口中方法的定义修饰符，只能是public，不能是其他的修饰
	//接口中，只能定义方法，不能实现方法
	//接口是抽象类的一种特殊形式
	//查询余额
	public double getBalance();
	//取钱
	public boolean drawMoney(double number);
	//检查密码
	public boolean checkPwd(String input);
}
