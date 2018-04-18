package com.test1.area;

public abstract class Shape {
	protected double c;
	//抽象类里面可以没有抽象方法。
	//但是抽象方法必须在抽象类里面。
	//抽象方法是不允许实现的，只能在抽象类中定义。
	public abstract double area();//计算面积的抽象方法
	
	

	public void test(){
		System.out.println("抽象类里面可以定义实现一般方法");
	}
}
