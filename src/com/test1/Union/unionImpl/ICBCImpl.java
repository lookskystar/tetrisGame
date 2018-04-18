package com.test1.Union.unionImpl;

import com.test1.Union.union.ICBC;

//�ࣺ����������������ʵ�ʷ��еĿ�Ƭ
//�ÿ�Ƭ���еĹ���ʵ��ICBC�Ľӿ�
public class ICBCImpl implements ICBC {
	private double money;
	private String pwd;
	
	public ICBCImpl(double money, String pwd) {
		super();
		this.money = money;
		this.pwd = pwd;
	}
	
	//����֧��
	@Override
	public void payOnline(double number) {
		if(number<money){
			money-=number;
		}
	}
	//�������
	@Override
	public boolean checkPwd(String input) {
		if(pwd.equals(input)){
			return true;
		}
		return false;
	}

	//ȡǮ
	@Override
	public boolean drawMoney(double number) {
		//�ж�ȡǮ�Ľ���Ƿ�����ҪС
		if(number<=money){
			money-=number; //���-��Ҫȡ�Ľ��
			return true;
		}
		return false;
	}

	//��ѯ���
	@Override
	public double getBalance() {
		return money;
	}
	
}
