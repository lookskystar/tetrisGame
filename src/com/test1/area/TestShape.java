package com.test1.area;

//����
public class TestShape {
	public static void main(String[] args) {
		Shape[] shapes=new Shape[2];
		shapes[0]=new Circle(4);//�����еĵ�һ��Ԫ��ΪԲ�ζ����ܳ�Ϊ4
		shapes[1]=new Square(4);//�����еĵڶ���Ԫ��Ϊ�����ζ����ܳ�Ϊ4
		
		ShapeUtil.maxArea(shapes);
	}
}
