package com.test1.Union.union;
//�ӿڣ�������������ͬ���ƶ��Ĺ���
public interface UnionPay {
	//�ӿ��з����Ķ������η���ֻ����public������������������
	//�ӿ��У�ֻ�ܶ��巽��������ʵ�ַ���
	//�ӿ��ǳ������һ��������ʽ
	//��ѯ���
	public double getBalance();
	//ȡǮ
	public boolean drawMoney(double number);
	//�������
	public boolean checkPwd(String input);
}
