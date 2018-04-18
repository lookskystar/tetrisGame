package com.tetrisGame2V10;

public class TestT {

	public static void main(String[] args) {
		T t=new T(0,1);
		System.out.println("原始的坐标：");
		t.print();
		
		//测试drop方法
//		t.drop();
//		System.out.println("调用drop方法后的坐标");
//		t.print();
		
		//测试moveLeft方法
//		t.movLeft();
//		System.out.println("调用moveLeft方法后的坐标：");
//		t.print();
		
		t.movRight();
		System.out.println("调用movRight方法后的坐标：");
		t.print();
		

	}

}
