package com.tetrisGame2V10;

public class TestT {

	public static void main(String[] args) {
		T t=new T(0,1);
		System.out.println("ԭʼ�����꣺");
		t.print();
		
		//����drop����
//		t.drop();
//		System.out.println("����drop�����������");
//		t.print();
		
		//����moveLeft����
//		t.movLeft();
//		System.out.println("����moveLeft����������꣺");
//		t.print();
		
		t.movRight();
		System.out.println("����movRight����������꣺");
		t.print();
		

	}

}
