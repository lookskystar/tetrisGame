package com.test1.area;

//测试
public class TestShape {
	public static void main(String[] args) {
		Shape[] shapes=new Shape[2];
		shapes[0]=new Circle(4);//数组中的第一个元素为圆形对象，周长为4
		shapes[1]=new Square(4);//数组中的第二个元素为正方形对象，周长为4
		
		ShapeUtil.maxArea(shapes);
	}
}
