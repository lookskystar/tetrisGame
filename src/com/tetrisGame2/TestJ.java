package com.tetrisGame2;

public class TestJ {

	public static void main(String[] args) {
		J j=new J(17,3);
		System.out.println("原始坐标为：");
		j.print();
		
		//测试drop方法
//		j.drop();
//		System.out.println("调用drop方法后的坐标：");
//		j.print();
		
		//测试moveLeft方法
//		j.moveLeft();
//		System.out.println("调用moveLeft方法后的坐标：");
//		j.print();
		
		//测试moveRight方法
		j.moveRight();
		System.out.println("调用moveRight方法后的坐标：");
		j.print();
		
	}
	
}
