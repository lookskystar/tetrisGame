package com.test1.area;

public class Circle extends Shape{
	private double c;
	public Circle(double c){
		this.c=c;
	}
	//���������ε����
	public double area(){
		return 0.0796*c*c;
	}
}
