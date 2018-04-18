package com.test1.Union.unionImpl;

import com.test1.Union.union.ABC;

//�ࣺ����������������ʵ�ʷ��еĿ�Ƭ
//�ÿ�Ƭ���еĹ���ʵ��ICBC�Ľӿ�
public class ABCImpl implements ABC {
	private double money;
	private String pwd;
	//�������������͸֧2000
	private double balance;
	
	public ABCImpl(double money, String pwd) {
		super();
		this.money = money;
		this.pwd = pwd;
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

	//֧���绰��
	@Override
	public boolean payTelBill(String phoneNum, double sum) {
		if(phoneNum.length()==11&&(balance-sum)>=-2000){
			balance-=sum;
			return true;
		}
		return false;
	}
	
}
