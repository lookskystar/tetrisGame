package com.test1.area;

public class Square extends Shape {
	private double c;
	public Square(double c){
		this.c=c;
	}
	//���������ε����-ʵ�ֳ������еļ�����ĳ��󷽷������ʵ��
	public double area(){
		return 0.0625*c*c;
	}
}
