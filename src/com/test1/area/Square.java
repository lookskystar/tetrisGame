package com.test1.area;

public class Square extends Shape {
	private double c;
	public Square(double c){
		this.c=c;
	}
	//计算正方形的面积-实现抽象父类中的计算面的抽象方法定义的实现
	public double area(){
		return 0.0625*c*c;
	}
}
