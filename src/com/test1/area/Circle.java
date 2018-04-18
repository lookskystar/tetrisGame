package com.test1.area;

public class Circle extends Shape{
	private double c;
	public Circle(double c){
		this.c=c;
	}
	//计算正方形的面积
	public double area(){
		return 0.0796*c*c;
	}
}
